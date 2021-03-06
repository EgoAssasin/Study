package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseStep;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Egor on 21.01.2018.
 */
public class FullFillPage {

    @FindBy(xpath = "//span [contains(text(),'Оформление')]" )
    public WebElement issueTitle;

    @FindBy(name = "insured0_surname")
    public WebElement insuredSurname;

    @FindBy(name = "insured0_name")
    public WebElement insuredName;

    @FindBy(name = "insured0_birthDate")
    public WebElement insuredBirthDate;

    @FindBy(name = "surname")
    public WebElement surname;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name = "middlename")
    public WebElement middlename;

    @FindBy(name = "birthDate")
    public WebElement birthDate;

    @FindBy(name = "passport_series")
    public WebElement passportSeries;

    @FindBy(name = "passport_number")
    public WebElement passportNumber;

    @FindBy(name = "issueDate")
    public WebElement issueDate;

    @FindBy(name = "issuePlace")
    public WebElement issuePlace;

    @FindBy(xpath = "//span [contains(text(),'Продолжить')]" )
    public WebElement continueBatton;

    @FindBy(xpath = "//div [text()='Заполнены не все обязательные поля']" )
    public WebElement alertText;

    public FullFillPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        wait.until(ExpectedConditions.visibilityOf(issueTitle));
        wait.until(ExpectedConditions.visibilityOf(continueBatton));

    }

    protected void fullFillRefactor(WebElement element, String value)
    {
        element.clear();
        element.sendKeys(value);
    }

    public void fullFillPole(String fildName, String value){
        switch (fildName){
            case "ФамилияСтрахуемого":
                fullFillRefactor(insuredSurname, value);
                break;
            case "ИмяСтрахуемого":
                fullFillRefactor(insuredName, value);
                break;
            case "ДатаРожденияСтрахуемого":
                fullFillRefactor(insuredBirthDate, value);
                break;
            case "Фамилия":
                fullFillRefactor(surname, value);
                break;
            case "Имя":
                fullFillRefactor(name, value);
                break;
            case "Отчество":
                fullFillRefactor(middlename, value);
                break;
            case "ДатаРождения":
                fullFillRefactor(birthDate, value);
                break;
            case "ПаспортСерия":
                fullFillRefactor(passportSeries, value);
                break;
            case "ПаспортНомер":
                fullFillRefactor(passportNumber, value);
                break;
            case "ПаспортДатаВыдачи":
                fullFillRefactor(issueDate, value);
                break;
            case "ПаспортГдеВыдан":
                fullFillRefactor(issuePlace, value);
                break;
            default: throw new AssertionError("Поле '" + fildName + "' не объявлено на странице");
        }
    }

    public String getFillPole(String fildName){
        switch (fildName){
            case "ФамилияСтрахуемого":
                return insuredSurname.getAttribute("value");
            case "ИмяСтрахуемого":
                return insuredName.getAttribute("value");
            case "ДатаРожденияСтрахуемого":
                return insuredBirthDate.getAttribute("value");
            case "Фамилия":
                return surname.getAttribute("value");
            case "Имя":
                return name.getAttribute("value");
            case "Отчество":
                return middlename.getAttribute("value");
            case "ДатаРождения":
                return birthDate.getAttribute("value");
            case "ПаспортСерия":
                return passportSeries.getAttribute("value");
            case "ПаспортНомер":
                return passportNumber.getAttribute("value");
            case "ПаспортДатаВыдачи":
                return issueDate.getAttribute("value");
            case "ПаспортГдеВыдан":
                return issuePlace.getAttribute("value");
        }
        throw new AssertionError("Нет такого поля!");
    }


    public void checkErrorMessage(String errorMessage){
        String alertText = BaseStep.getDriver().findElement(By.xpath("//div [text()='Заполнены не все обязательные поля']")).getText();
        assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", alertText, errorMessage),alertText.equals(errorMessage));
    }
}
