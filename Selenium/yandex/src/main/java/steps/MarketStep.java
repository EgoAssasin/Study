package steps;

import pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Egor on 23.01.2018.
 */
public class MarketStep {
    @Step("Выбран пункт меню {0}")
    public void stepSelectMainMenu (String menuItem){
        MarketPage marketPage =  new MarketPage(BaseStep.getDriver());
        marketPage.selectMainMenu(menuItem);
    }

    @Step("Выбран пункт подменю {0}")
    public void stepSelectSubMenu(String menuItem){
        new MarketPage(BaseStep.getDriver()).selectSubMenu(menuItem);
    }
}
