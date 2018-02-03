package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TextTransfer;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Egor on 21.01.2018.
 */
public class ItemPage {

    @FindBy(xpath = "//h1[contains(@class,'title')]")
    WebElement itemDescription;
    @FindBy(xpath = "//div[@class='n-snippet-card2__hover'or@class='n-snippet-cell2__hover']/parent::*" )
    public List<WebElement> discoverItems;


    public ItemPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        /*Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        wait.until(ExpectedConditions.visibilityOf(itemDescription)); */
        //System.out.println("Таблица продуктов содержит: " + discoverItems.size());


    }

    public void checkItem(){
        System.out.println("----------------------");
        TextTransfer textTransfer = new TextTransfer();
        System.out.println(textTransfer.getClipboardContents());
        if(discoverItems.size()==0) {
            System.out.println(itemDescription.getText());
            System.out.println("----------------------");
            assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]",itemDescription.getText(), textTransfer.getClipboardContents()),itemDescription.getText().equals(textTransfer.getClipboardContents()));
        }
        if(discoverItems.size()>0)  {
            WebElement firstElement=discoverItems.get(0).findElement(By.xpath(".//div[@class='n-snippet-card2__title'or@class='n-snippet-cell2__title']/a"));
            System.out.println(firstElement.getText());
            System.out.println("----------------------");
            assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]",firstElement.getText(), textTransfer.getClipboardContents()),firstElement.getText().equals(textTransfer.getClipboardContents()));

        }
    }
}
