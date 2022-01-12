package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // features klasorunun path'i eklenir --> sag click, copy path, path from content root
        features = "src/test/resources/features",
        // features klasorundeki feature'larin kodalari cekecegi klasor (stepdefinations)
        glue = "stepdefinations",
        // hangi tag'lerin calistiralacagini secer
        tags = "@US001",

        // true yapilirsa belirtilen tag'lerin kod derleme hatalarini kontrol eder
        // false yapilirsa belirtilen tag'leri calistirarak reeldeki hatalarini kontrol eder
        dryRun = false
)
public class Runner {

}
