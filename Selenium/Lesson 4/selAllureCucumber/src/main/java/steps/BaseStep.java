package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Egor on 21.01.2018.
 */
public class BaseStep {
    protected static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getINSTANCE().getProperties();

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public static void setUp() throws Exception {

        String s = properties.getProperty("browser");
        if (s.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
            driver = new FirefoxDriver();

        } else if (s.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
            driver = new FirefoxDriver();

        } else {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
            driver = new FirefoxDriver();
        }
        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @After
    public static void tearDown() throws Exception{
        driver.quit();
    }
}
