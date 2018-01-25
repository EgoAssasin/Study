package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Egor on 21.01.2018.
 */
public class TravelPage {
    @FindBy(xpath = "//h1[contains(text(),'Страхование путешественников')]")
    public WebElement title;

    @FindBy(xpath = "//a//img [contains(@src,'banner-zashita-traveler')]")
    public WebElement batton;

    public TravelPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        wait.until(ExpectedConditions.visibilityOf(title));
        wait.until(ExpectedConditions.visibilityOf(batton));
    }
}
