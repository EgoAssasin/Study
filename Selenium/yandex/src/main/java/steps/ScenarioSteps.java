package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Egor on 27.01.2018.
 */
public class ScenarioSteps {

    MainStep mainStep = new MainStep();
    MarketStep marketStep = new MarketStep();
    FullFillStep fullFillStep = new FullFillStep();
    ItemPageStep itemPageStep = new ItemPageStep();

    @When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem){
        mainStep.stepSelectMainMenu(menuItem);
    }

    @When("^выбран раздел - \"(.*)\"$")
    public void stepMarketMenu(String menuItem){
        marketStep.stepSelectMainMenu(menuItem);
    }

    @Then("^выбран подраздел - \"(.*)\"$")
    public void stepMarketSubMenu(String menuItem){
        marketStep.stepSelectSubMenu(menuItem);
    }

    @When("^заполняются поля:$")
    public void stepFullfillFields(DataTable fields){
        fields.asMap(String.class,String.class).forEach(
                (key,value) -> fullFillStep.stepFullFill(key,value)
        );
    }
    @When("^нажата кнопка - Применить")
    public void stepSendButtonContinue(){
        fullFillStep.stepSendApplyBatton();
    }


    @Then("^количество элементов на странице равно - \"(.*)\"$")
    public void stepCheckDiscoverItems(Byte menuItem){
        fullFillStep.stepCheckDiscoverItems(menuItem);
    }

    @When("^заполнена строка поиска")
    public void stepFillSarch(){
        fullFillStep.stepSearch();
    }

    @When("^нажата кнопка - Найти")
    public void stepSendFind(){
        fullFillStep.stepSendFindButton();
    }

    @Then("^наименование товара соответствует запомненному значению")
    public void stepChekItem(){ itemPageStep.stepCheckItem();
    }


}
