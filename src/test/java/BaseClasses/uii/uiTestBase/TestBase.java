package BaseClasses.uii.uiTestBase;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        Configuration.baseUrl = "https://potolkoff58.ru";
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
    }

    @After
    public void tearDown() {
        if(WebDriverRunner.getWebDriver()!= null) {
            WebDriverRunner.getWebDriver().quit();
        }
    }
}
