package helpers.Ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {
    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        System.out.println("init completed");
    }

    @After
    public void tearDown() {
        if(WebDriverRunner.getWebDriver()!= null) {
            WebDriverRunner.getWebDriver().quit();
        }
        System.out.println("tearDown completed");
    }
}
