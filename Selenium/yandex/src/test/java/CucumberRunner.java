import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Egor on 27.01.2018.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"}, glue = {"steps"},
        plugin = {
                "util.AllureReporter"
        })
public class CucumberRunner {}
