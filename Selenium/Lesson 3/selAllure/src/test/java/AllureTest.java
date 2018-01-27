import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Egor on 23.01.2018.
 */
public class AllureTest extends BaseStep {
    @Test
    //@Ignore
    @Title("Страхование путешественников")
    public void allureInsuranceTest() throws InterruptedException {
        MainStep mainStep = new MainStep();
        TravelStep travelStep = new TravelStep();
        ChoiceSumStep choiceSumStep = new ChoiceSumStep();
        FullFillStep fullFillStep = new FullFillStep();

        HashMap<String,String> testData = new HashMap<>();
        testData.put("ФамилияСтрахуемого","Romanov");
        testData.put("ИмяСтрахуемого","Petr");
        testData.put("ДатаРожденияСтрахуемого","09.05.1965");
        testData.put("Фамилия","Романов");
        testData.put("Имя","Игорь");
        testData.put("Отчество","Петрович");
        testData.put("ДатаРождения","01.08.1985");
        testData.put("ПаспортСерия","9300");
        testData.put("ПаспортНомер","635987");
        testData.put("ПаспортДатаВыдачи","10.11.2005");
        testData.put("ПаспортГдеВыдан","Город N");

        mainStep.stepSelectMainMenu("Раздел Застраховать себя  и имущество");
        mainStep.stepSelectSubMenu("Страхование путешественников");
        travelStep.chekTitle("Страхование путешественников");
        travelStep.stepsSendIssueButton();
        ArrayList<String> NewTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(NewTab.get(1));
        choiceSumStep.stepChoiceSum("Минимальная");
        Thread.currentThread().sleep(500) ; //Сделаем задержку в 1 сек. чтобы скролл быстро так не проходил
        fullFillStep.stepFullFill(testData);
        fullFillStep.checkFullField(testData);
        fullFillStep.stepSendContinueButton();
        fullFillStep.stepCheckErrorMessage("Заполнены не все обязательные поля");
    }
}
