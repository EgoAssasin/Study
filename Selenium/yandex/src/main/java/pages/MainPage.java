package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseStep;

/**
 * Created by Egor on 21.01.2018.
 */
public class MainPage {


    @FindBy(xpath = "//div [@class='home-arrow__tabs']")
    WebElement mainMenu;


    public MainPage(WebDriver driver){
        PageFactory.initElements(BaseStep.getDriver(), this);
    }

    public void selectMainMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//a[contains(text(),'" + menuItem + "')]")).click();
    }

}
