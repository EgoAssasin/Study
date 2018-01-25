package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Egor on 21.01.2018.
 */
public class MainPage {


    @FindBy(xpath = "//div [@class='sbrf-div-list-inner --area bp-area header_more_nav']")
    WebElement mainMenu;

    @FindBy(xpath = "//div [@class='sbrf-div-list-inner --area bp-area header_more_nav']//a[contains(@aria-label,'Раздел Застраховать себя  и имущество')]/parent::li/div[@class='alt-menu-collapser__area alt-menu-collapser__area_cols_3']")
    WebElement subMenu;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//a[contains(@aria-label,'" + menuItem + "')]")).click();

    }

    public void selectSubMenu(String menuItem){
        subMenu.findElement(By.xpath(".//a[@href='" + menuItem + "']")).click();

    }
}
