import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Egor on 15.01.2018.
 */
public class InsuranceTest {
    WebDriver driver;
    Actions actions;
    String url,url2,url3;
    @Before
    public void beforeTest(){
        System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
        url="http://www.sberbank.ru/ru/person";
        url2="http://www.sberbank.ru/ru/person/bank_inshure/insuranceprogram/life/travel";
        url3="https://online.sberbankins.ru/store/vzr/index.html#/viewCalc";
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);


    }

    @Test
    public void insuarenseTest() throws InterruptedException {

        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);

        //Здесь постоянно ловлю ошибку "StaleElementReferenceException: The element reference of <a href="/ru/person/bank_inshure/insuranceprogram/life/travel"> stale; either the element is no longer attached to the DOM, it is not in the current frame context, or the document has been refreshed"

        /**
         * Ищу элемент "Застраховать себя и имущество"
         */
        WebElement elementMenu = driver.findElement(By.xpath("//span[contains(text(),'Застраховать себя')]/parent::*/parent::*/parent::*"));
        wait.until(ExpectedConditions.visibilityOf(elementMenu));
        /**
         * Навожу мышь на элемент, чтобы стали активными элементы раскрывшегося списка
         */
        actions = new Actions(driver);
        actions.moveToElement(elementMenu).build().perform();

        /**
         * Ищу и кликаю в "Страхование путешественников", т.к. теперь данный элемент активным стал
         */
        WebElement elementFromMenu = driver.findElement(By.xpath("//a[contains(@href,'life/travel')]"));
        wait.until(ExpectedConditions.visibilityOf(elementFromMenu));
        elementFromMenu.click();

        /**
         * В овом окне ищу заголовок – Страхование путешественников и проверяю Assert-ом
         */
        WebElement title = driver.findElement(By.xpath("//h1[contains(text(),'Страхование путешественников')]"));
        wait.until(ExpectedConditions.visibilityOf(title));
        Assert.assertEquals("Страхование путешественников",title.getText());

        /**
         * Ищу и нажимаю кнопку "Оформить Онлайн"
         */
        WebElement issueBattonOnline = driver.findElement(By.xpath("//a//img [contains(@src,'banner-zashita-traveler')]"));
        wait.until(ExpectedConditions.visibilityOf(issueBattonOnline)).click();

        /**
         * Переключаю фокус драйвера на новую открытую вкладку
         */
        ArrayList <String> NewTab = new ArrayList<String>(driver.getWindowHandles());
        //System.out.println(NewTab.size()+" | "+ NewTab.get(0) + " | "+ NewTab.get(1));
        driver.switchTo().window(NewTab.get(1));

        /**
         * Поиск,скролл к элементу и выбор суммы страховой защиты – Минимальная
         */
        WebElement minimumInsuranceProtection = driver.findElement(By.xpath("//div [contains(text(),'Минимальная')]/parent::*/parent::*"));
        //wait.until(ExpectedConditions.visibilityOf(minimumInsuranceProtection)).click();
        wait.until(ExpectedConditions.visibilityOf(minimumInsuranceProtection));
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",minimumInsuranceProtection);
        Thread.currentThread().sleep(1000) ; //Сделаем задержку в 1 сек. чтобы скролл быстро так не проходил
        minimumInsuranceProtection.click();


        /**
         * Поиск и нажатие кнопки "Оформить"
         */
        WebElement issueBatton = driver.findElement(By.xpath("//span [contains(text(),'Оформить')]"));
        wait.until(ExpectedConditions.visibilityOf(issueBatton)).click();

        /**
         * Поиск элеиента "Оформление"
         */
        WebElement issue = driver.findElement(By.xpath("//span [contains(text(),'Оформление')]"));
        wait.until(ExpectedConditions.visibilityOf(issue));

        /**
         * Заполнение полей формы "Оформление"
         */
        fullFill(By.name("insured0_surname"),"Romanov");
        fullFill(By.name("insured0_name"),"Petr");
        fullFill(By.name("insured0_birthDate"),"09.05.1965");
        fullFill(By.name("surname"),"Романов");
        fullFill(By.name("name"),"Игорь");
        fullFill(By.name("middlename"),"Петрович");
        fullFill(By.name("birthDate"),"01.08.1985");
        fullFill(By.name("passport_series"),"9300");
        fullFill(By.name("passport_number"),"6359874");
        fullFill(By.name("issueDate"),"10.11.2005");
        fullFill(By.name("issuePlace"),"Город N");

        /**
         *  Поиск и нажатие кнопки "Продолжить"
         */
        WebElement continueBatton = driver.findElement(By.xpath("//span [contains(text(),'Продолжить')]"));
        wait.until(ExpectedConditions.visibilityOf(continueBatton)).click();

        /**
         * Поиск элемента сообщения об ошибке и проверка Assert-ом
         */
        WebElement alertText = driver.findElement(By.xpath("//div [text()='Заполнены не все обязательные поля']"));
        wait.until(ExpectedConditions.visibilityOf(alertText));
        Assert.assertEquals("Заполнены не все обязательные поля",alertText.getText());



    }

    public void fullFill(By locator,String value)
    {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    @After
    public  void afterTest(){
        driver.quit();

    }
}
