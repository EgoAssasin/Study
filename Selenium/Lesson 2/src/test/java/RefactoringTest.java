import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ChoiceSumPage;
import pages.FullFillPage;
import pages.MainPage;
import pages.TravelPage;

import java.util.ArrayList;

/**
 * Created by Egor on 21.01.2018.
 */
public class RefactoringTest extends BaseTest {

    @Test
    public void newInsuranceTest() throws InterruptedException {

        /**
         * Выбор элемента "Застраховать себя и имущество"--> "Страхование путешественников"
         */
        MainPage mainPage=new MainPage(driver);
        mainPage.selectMainMenu("Раздел Застраховать себя  и имущество");
        mainPage.selectSubMenu("/ru/person/bank_inshure/insuranceprogram/life/travel");

        /**
         * В новом окне ищу заголовок – Страхование путешественников и проверяю Assert-ом
         */
        TravelPage travelPage = new TravelPage(driver);
        Assert.assertEquals("Страхование путешественников",travelPage.title.getText());
        travelPage.batton.click();
        ArrayList<String> NewTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(NewTab.get(1));

        /**
         * Выбир max суммы страхования
         */
        ChoiceSumPage choiceSumPage = new ChoiceSumPage(driver);
        choiceSumPage.selectSum("Минимальная");
        Thread.currentThread().sleep(500) ; //Сделаем задержку в 1 сек. чтобы скролл быстро так не проходил
        choiceSumPage.selectIssueButton();

        /**
         * Заполнение полей формы "Оформление"
         */
        FullFillPage fullFillPage = new FullFillPage(driver);
        fullFillPage.fullFillPole("ФамилияСтрахуемого","Romanov");
        fullFillPage.fullFillPole("ИмяСтрахуемого","Petr");
        fullFillPage.fullFillPole("ДатаРожденияСтрахуемого","09.05.1965");
        fullFillPage.fullFillPole("Фамилия","Романов");
        fullFillPage.fullFillPole("Имя","Игорь");
        fullFillPage.fullFillPole("Отчество","Петрович");
        fullFillPage.fullFillPole("ДатаРождения","01.08.1985");
        fullFillPage.fullFillPole("ПаспортСерия","9300");
        fullFillPage.fullFillPole("ПаспортНомер","635987");
        fullFillPage.fullFillPole("ПаспортДатаВыдачи","10.11.2005");
        fullFillPage.fullFillPole("ПаспортГдеВыдан","Город N");


        /**
         * Проверяю поля формы "Оформление"
         */
        Assert.assertEquals("Romanov",fullFillPage.insuredSurname.getAttribute("value"));
        Assert.assertEquals("Petr",fullFillPage.insuredName.getAttribute("value"));
        Assert.assertEquals("09.05.1965",fullFillPage.insuredBirthDate.getAttribute("value"));
        Assert.assertEquals("Романов",fullFillPage.surname.getAttribute("value"));
        Assert.assertEquals("Игорь",fullFillPage.name.getAttribute("value"));
        Assert.assertEquals("Петрович",fullFillPage.middlename.getAttribute("value"));
        Assert.assertEquals("01.08.1985",fullFillPage.birthDate.getAttribute("value"));
        Assert.assertEquals("9300",fullFillPage.passportSeries.getAttribute("value"));
        Assert.assertEquals("635987",fullFillPage.passportNumber.getAttribute("value"));
        Assert.assertEquals("10.11.2005",fullFillPage.issueDate.getAttribute("value"));
        Assert.assertEquals("Город N",fullFillPage.issuePlace.getAttribute("value"));

        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",fullFillPage.continueBatton);
        fullFillPage.continueBatton.click();//нажимаю кнопку "Продолжить"


        /**
         * Поиск элемента сообщения об ошибке и проверка Assert-ом
         */
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        WebElement alertText = driver.findElement(By.xpath("//div [text()='Заполнены не все обязательные поля']"));
        wait.until(ExpectedConditions.visibilityOf(alertText));
        Assert.assertEquals("Заполнены не все обязательные поля",alertText.getText());


    }

}
