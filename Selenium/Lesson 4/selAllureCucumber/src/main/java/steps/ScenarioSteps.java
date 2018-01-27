package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;

/**
 * Created by Egor on 27.01.2018.
 */
public class ScenarioSteps {

    MainStep mainStep = new MainStep();
    TravelStep travelStep = new TravelStep();
    ChoiceSumStep choiceSumStep = new ChoiceSumStep();
    FullFillStep fullFillStep = new FullFillStep();

    @When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem){
        mainStep.stepSelectMainMenu(menuItem);
    }

    @Then("^выбран вид страхования \"(.*)\"$")
    public void stepSelectTypeInsurance(String menuItem){
        mainStep.stepSelectSubMenu(menuItem);
    }

    @When("^заголовок открывшейся страницы равен - \"(.*)\"$")
    public void stepCheckTitleTravel(String menuItem){
        travelStep.chekTitle(menuItem);
    }

    @Then("^нажата кнопка - Оформить онлайн")
    public void stepSendButtonIsOnline(){
        travelStep.stepsSendIssueButton();
    }

    @When("^переключились в новое окно")
    public void switchToNewWindow(){
        ArrayList<String> NewTab = new ArrayList<String>(BaseStep.getDriver().getWindowHandles());
        BaseStep.getDriver().switchTo().window(NewTab.get(1));
    }

    @Then("^выбрана сумма страхования \"(.*)\"$")
    public void stepSumOfInsurence(String menuItem){
        choiceSumStep.stepChoiceSum(menuItem);
    }

    @When("^заполняются поля:$")
    public void stepFullfillFields(DataTable fields){
        fields.asMap(String.class,String.class).forEach(
                (key,value) -> fullFillStep.stepFullFill(key,value)
        );
    }

    @Then("^проверяются поля, что заполненны следующими значениями:$")
    public void stepCheckFields(DataTable fields){
        fields.asMap(String.class,String.class).forEach(
                (key,value) -> fullFillStep.checkFullField(key,value)
        );
    }

    @When("^нажата кнопка - Продолжить")
    public void stepSendButtonContinue(){
        fullFillStep.stepSendContinueButton();
    }


    @Then("^ошибка сообщения равна - \"(.*)\"$")
    public void stepCheckErrorMessage(String menuItem){
        fullFillStep.stepCheckErrorMessage(menuItem);
    }
}
