package steps;

import pages.FullFillPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Egor on 23.01.2018.
 */
public class FullFillStep{

    @Step("Поле {0} заполняется значением {1}")
    public void stepFullFill(String fildName,String value){
        new FullFillPage(BaseStep.getDriver()).fullFillPole(fildName,value);
    }

    @Step("Нажать на кнопку - Применить")
    public void stepSendApplyBatton(){
        new FullFillPage(BaseStep.getDriver()).clickApplyBatton();
    }

    @Step("Проверка количества элементов на странице")
    public void stepCheckDiscoverItems(Byte value){
        new FullFillPage(BaseStep.getDriver()).checkDiscoverItems(value);
    }

    @Step("Ввод в поисковую строку первого элемента из списка")
    public void stepSearch(){
        new FullFillPage(BaseStep.getDriver()).fillSearch();
    }

    @Step("Нажать на кнопку - Найти")
    public void stepSendFindButton(){
        new FullFillPage(BaseStep.getDriver()).findBatton.click();
    }

}
