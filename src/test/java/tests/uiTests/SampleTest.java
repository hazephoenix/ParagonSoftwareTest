package tests.uiTests;

import BaseClasses.uii.uiTestBase.TestBase;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.*;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SampleTest extends TestBase {

    @Test
    public void sample() {
        List<String> menus = Arrays.asList("КАТАЛОГ ПОТОЛКОВ", "ОСВЕЩЕНИЕ", "ФОТОГАЛЕРЕЯ","ПРАЙС-ЛИСТ","ПОЛЕЗНЫЕ СТАТЬИ", "ВАШИ ВОПРОСЫ", "КОНТАКТЫ");
        List<String> items = Arrays.asList("Одноуровневые потолки", "Двухуровневые потолки", "Тканевые потолки", "\"Парящие потолки\"", "Криволинейная спайка потолка", "Фотопечать");
        List<String> types = Arrays.asList("Квартиры, частные дома", "Офисные помещения");
        List <Object> picturesUrls = new ArrayList<>();
        open("/");
        $$(".topmenu.nav>li").
                shouldHaveSize(7).
                shouldHave(CollectionCondition.exactTexts(menus));
        $(By.xpath("(//a[text()='Фотогалерея'])[1]")).click();
        $("#zag_2").should(exist);
        $$("#catalog_cat .cat_zag").shouldHaveSize(6).shouldHave(CollectionCondition.exactTexts(items));
        $(By.xpath("//*[contains(text(),'ТИП ПОМЕЩЕНИЯ')]")).click();
        $$("#catalog_cat>div .cat_zag").shouldHaveSize(2).shouldHave(CollectionCondition.exactTexts(types));
        $(By.xpath("//*[contains(text(),'ЛЮСТРЫ И СВЕТИЛЬНИКИ')]")).click();
        $$("#catalog_cat a").forEach(element->picturesUrls.add(element.getAttribute("href")));
        System.out.println(picturesUrls);

    }
}
