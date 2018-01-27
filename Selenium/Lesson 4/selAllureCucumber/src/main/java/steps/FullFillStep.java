package steps;

import pages.FullFillPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Egor on 23.01.2018.
 */
public class FullFillStep{

    @Step("Поле {0} заполняется значением {1}")
    public void stepFullFill(String fildName,String value){
        new FullFillPage(BaseStep.getDriver()).fullFillPole(fildName,value);
    }

    @Step("Заполнение полей:")
    public void stepFullFill(HashMap<String,String> fields){
        fields.forEach((key, value)->stepFullFill(key,value));
    }


    @Step("Поле {0} заполнено значением {1}")
    public void checkFullField(String field, String value){
        String actualDataInPole = new FullFillPage(BaseStep.getDriver()).getFillPole(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actualDataInPole, value),actualDataInPole.equals(value));
    }

    @Step("Поля заполнены следующими данными:")
    public void checkFullField(HashMap<String,String> fields){
        fields.forEach((k, v)-> checkFullField(k,v));
    }

    @Step("Нажать на кнопку - Продолжить")
    public void stepSendContinueButton(){
        new FullFillPage(BaseStep.getDriver()).continueBatton.click();
    }

    @Step("Проверка сообщения об ошибке по заполнению полей")
    public void stepCheckErrorMessage(String value){
        new FullFillPage(BaseStep.getDriver()).checkErrorMessage(value);
    }
}
