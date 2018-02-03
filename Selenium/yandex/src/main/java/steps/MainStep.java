package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Egor on 23.01.2018.
 */
public class MainStep{

    @Step("Выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem){
        new MainPage(BaseStep.getDriver()).selectMainMenu(menuItem);
    }

}
