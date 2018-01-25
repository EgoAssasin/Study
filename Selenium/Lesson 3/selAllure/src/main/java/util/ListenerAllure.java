package util;

import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import steps.BaseStep;

/**
 * Created by Egor on 23.01.2018.
 */
public class ListenerAllure extends ru.yandex.qatools.allure.junit.AllureRunListener{

    @Override
    public void testFailure(Failure failure){
        takeScreeShot();
        super.testFailure(failure);
    }

    @Attachment(type = "image/png",value = "Скриншот ошибки")
    public byte[] takeScreeShot(){
        return  ((TakesScreenshot) BaseStep.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
