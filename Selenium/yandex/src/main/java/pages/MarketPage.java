package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseStep;

/**
 * Created by Egor on 21.01.2018.
 */
public class MarketPage {
    @FindBy(xpath = "//div[@class='popup2__content']//span")
    public WebElement acceptRegion;

    @FindBy(xpath = "//ul [@class='topmenu__list']")
    public WebElement mainMenu;

    @FindBy(xpath = "//li [@data-department='Электроника']//div[@class='topmenu__subwrap']")
    public WebElement subMenu;

    Actions actions;

    public MarketPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void selectAccRegion(){
        Wait<WebDriver> wait = new WebDriverWait(BaseStep.getDriver(),10, 1000);
        wait.until(ExpectedConditions.visibilityOf(acceptRegion));
        acceptRegion.click();
    }

    public void selectMainMenu(String menuItem){
        selectAccRegion();
        actions = new Actions(BaseStep.getDriver());
        actions.moveToElement(mainMenu.findElement(By.xpath("./li/a[contains(text(),'" + menuItem + "')]"))).build().perform();//Электроника

    }

    public void selectSubMenu(String menuItem){
        Wait<WebDriver> wait = new WebDriverWait(BaseStep.getDriver(),10, 1000);
        WebElement elementSubMenu = subMenu.findElement(By.xpath(".//a[contains(text(),'" + menuItem + "')]/img")); //Телевизоры
        wait.until(ExpectedConditions.visibilityOf(elementSubMenu));
        elementSubMenu.click();
    }
}
