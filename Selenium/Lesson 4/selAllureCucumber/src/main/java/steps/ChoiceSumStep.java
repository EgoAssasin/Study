package steps;

import pages.ChoiceSumPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Egor on 23.01.2018.
 */
public class ChoiceSumStep{
    @Step("Выбрана max сумма страхования{0}")
    public void stepChoiceSum(String menuItem){
        ChoiceSumPage choice = new ChoiceSumPage(BaseStep.getDriver());
        choice.selectSum(menuItem);
        choice.selectIssueButton();
    }
}
