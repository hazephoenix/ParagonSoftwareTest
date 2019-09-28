package tests.uiTests;

import BaseClasses.uii.uiTestBase.TestBase;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SampleTest extends TestBase {

    @Test
    public void sample() {
        List<String> menus = Arrays.asList("КАТАЛОГ ПОТОЛКОВ", "ОСВЕЩЕНИЕ", "ФОТОГАЛЕРЕЯ","ПРАЙС-ЛИСТ","ПОЛЕЗНЫЕ СТАТЬИ", "ВАШИ ВОПРОСЫ", "КОНТАКТЫ");
        List<String> catalog_items = Arrays.asList("Одноуровневые потолки", "Двухуровневые потолки", "Тканевые потолки", "\"Парящие потолки\"", "Криволинейная спайка потолка", "Фотопечать");
        open("/");
        $$(".topmenu.nav>li").
                shouldHaveSize(7).
                shouldHave(CollectionCondition.exactTexts(menus));
        $(By.xpath("(//a[text()='Фотогалерея'])[1]")).click();
        $("#zag_2").should(exist);
        $$("#catalog_cat .cat_zag").shouldHaveSize(6).shouldHave(CollectionCondition.exactTexts(catalog_items));
        $(By.xpath("//*[contains(text(),'ТИП ПОМЕЩЕНИЯ')]")).click();
    }
}
