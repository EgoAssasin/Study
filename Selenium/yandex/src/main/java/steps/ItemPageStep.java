package steps;

import pages.ItemPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Egor on 23.01.2018.
 */
public class ItemPageStep {
    @Step("Проверка, что наименование товара соответствует запомненному значению")
    public void stepCheckItem(){  new ItemPage(BaseStep.getDriver()).checkItem();
    }
}
