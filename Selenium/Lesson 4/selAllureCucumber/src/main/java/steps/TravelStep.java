package steps;

import pages.TravelPage;
import ru.yandex.qatools.allure.annotations.Step;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Egor on 23.01.2018.
 */
public class TravelStep {
    @Step("Нажать на кнопку - Оформить онлайн")
    public void stepsSendIssueButton(){
        new TravelPage(BaseStep.getDriver()).batton.click();
    }

    @Step("Проверить наличие на странице заголовка – Страхование путешественников")
    public void chekTitle(String titleElrment){
       String actualTitle = new TravelPage(BaseStep.getDriver()).title.getText();
       assertTrue(String.format("Заголовок на странице [%s]. Ожидалось - [%s]", actualTitle, titleElrment),actualTitle.equals(titleElrment));
    }
}
