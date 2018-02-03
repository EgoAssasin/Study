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
import util.TextTransfer;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Egor on 21.01.2018.
 */
public class FullFillPage {

    @FindBy(xpath = "//h1" )
    public WebElement issueTitle;

    @FindBy(name = "glf-pricefrom-var")
    public WebElement priceFrom;

    @FindBy(xpath = "//span[contains(text(),'Производитель')]/parent::*/parent::*/parent::*")
    public WebElement produceName;

    @FindBy(xpath = "//span[contains(text(),'Применить')]/parent::*" )
    public WebElement applyBatton;

    @FindBy(xpath = "//div[@class='n-snippet-card2__hover'or@class='n-snippet-cell2__hover']/parent::*/parent::*" )
    public WebElement discoverItemsParent;

    @FindBy(xpath = "//div[@class='n-snippet-card2__hover'or@class='n-snippet-cell2__hover']/parent::*" )
    public List<WebElement> discoverItems;

    @FindBy(name = "text" )
    public WebElement searchPole;

    @FindBy(xpath = "//span[contains(text(),'Найти')]/parent::*" )
    public WebElement findBatton;


    public FullFillPage(WebDriver driver){
        //System.out.println("--------------------------------------***********************************--------------------------------------");
        //System.out.println(driver.getCurrentUrl());
        //System.out.println("Конструктор первый элемент ДО инициализации: " + driver.findElements(By.xpath("//div[@class='n-snippet-card2__hover'or@class='n-snippet-cell2__hover']/parent::*")).get(0).getText());
       // System.out.println("******************************************");
        PageFactory.initElements(driver, this);
       // System.out.println("Конструктор первый элемент ПОСЛЕ инициализации: " + discoverItems.get(0).getText());
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        wait.until(ExpectedConditions.visibilityOf(issueTitle));
        wait.until(ExpectedConditions.visibilityOf(applyBatton));
    }

    public void clickApplyBatton(){
        //System.out.println("Процедура, первый элемент: " + discoverItems.get(0).getText());
        //System.out.println("Нажали кнопку применить");
        //JavascriptExecutor js =(JavascriptExecutor)BaseStep.getDriver();
        //js.executeScript("arguments[0].scrollIntoView(true);",applyBatton);
        applyBatton.click();
        BaseStep.getDriver().get(BaseStep.getDriver().getCurrentUrl());
        Wait<WebDriver> wait = new WebDriverWait(BaseStep.getDriver(),10, 1000);
        wait.until(ExpectedConditions.visibilityOf(discoverItemsParent));
        //System.out.println(BaseStep.getDriver().getCurrentUrl());
        /*ArrayList<String> NewTab = new ArrayList<String>(BaseStep.getDriver().getWindowHandles());
        System.out.println("Открыто окон: " + NewTab.size());*/
        //System.out.println(NewTab.size()+" | "+ NewTab.get(0) + " | "+ NewTab.get(1));
        //BaseStep.getDriver().switchTo().window(NewTab.get(1));
    }

    public void clickProduce(String produceItem){
        //System.out.println("Процедура, первый элемент: " + discoverItems.get(0).getText());
        //System.out.println("Выбрали производителя: " + produceItem);
        produceName.findElement(By.xpath(".//label[contains(text(),'"+ produceItem +"')]")).click();//кликаю производителя
    }

    protected void fullFillRefactor(WebElement element, String value)
    {
        //System.out.println("Процедура, первый элемент: " + discoverItems.get(0).getText());
        //System.out.println("Выбрали цену: " + element + "  |  " + value);
        element.clear();
        element.sendKeys(value);
    }

    public void fullFillPole(String fildName, String value){
        switch (fildName){
            case "Цена от:":
                fullFillRefactor(priceFrom, value);
                break;
            case "Производитель 1":
                clickProduce(value);
                break;
            case "Производитель 2":
                clickProduce(value);
                break;
            case "Поле поиска":
                fullFillRefactor(searchPole, value);
                break;

            default: throw new AssertionError("Поле '" + fildName + "' не объявлено на странице");
        }
    }

    public void checkDiscoverItems(byte numberItems){
        //System.out.println("Процедура, первый элемент: " + discoverItems.get(0).getText());
        assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", discoverItems.size(), numberItems),discoverItems.size()==numberItems);
    }

    public void fillSearch(){
        //System.out.println("Процедура, первый элемент: " + discoverItems.get(0).getText());
        WebElement firstElement=discoverItems.get(0).findElement(By.xpath(".//div[@class='n-snippet-card2__title'or@class='n-snippet-cell2__title']/a"));
        fullFillPole("Поле поиска",firstElement.getText());
        TextTransfer textTransfer = new TextTransfer();
        textTransfer.setClipboardContents(firstElement.getText());
    }
}
