package BaseClasses.uii.pageModel;

import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.util.Arrays.*;


public class MainPage {

    private static final List<String> menus = asList("КАТАЛОГ ПОТОЛКОВ", "ОСВЕЩЕНИЕ", "ФОТОГАЛЕРЕЯ","ПРАЙС-ЛИСТ","ПОЛЕЗНЫЕ СТАТЬИ", "ВАШИ ВОПРОСЫ", "КОНТАКТЫ");


    private static By getMenuSelector(String menuCaption) {
        return By.xpath("//a[text()='" + menuCaption + "']");
    }

    public static void checkAllMenus() {
        $$(".topmenu.nav>li").
                shouldHaveSize(7).
                shouldHave(CollectionCondition.exactTexts(menus));
    }

    public static void openGalleryPage() {
        $(getMenuSelector("Фотогалерея")).click();
    }

    public static void openPriceListPage() {
        $(getMenuSelector("Прайс-лист")).click();
    }

    public static void openContactsPage() {
        $(getMenuSelector("Контакты")).click();
    }
}





