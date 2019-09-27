package tests.UiTests;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SampleTest {

    @Test
    public void sample() {
        open("https://www.google.com/");
        $(By.xpath("//img[@alt='День осеннего равноденствия']")).shouldBe(visible);
    }
}
