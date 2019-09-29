package BaseClasses.uii.pageModel;

import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class GalleryPage {

    private static final List<String> items = Arrays.asList("Одноуровневые потолки", "Двухуровневые потолки", "Тканевые потолки", "\"Парящие потолки\"", "Криволинейная спайка потолка", "Фотопечать");
    private static final List<String> types = Arrays.asList("Квартиры, частные дома", "Офисные помещения");
    private static final List<Object> picturesUrls = new ArrayList<>();
    private static final List<Object> picturesUrls2 = new ArrayList<>();


    public static void checkHeaderAndItems() {
        $("#zag_2").should(exist).shouldHave(exactText("Фотогалерея"));
        $$("#catalog_cat .cat_zag").shouldHaveSize(6).shouldHave(CollectionCondition.exactTexts(items));
    }

    public static void openRoomsTypeList() {
        $(By.xpath("//*[contains(text(),'ТИП ПОМЕЩЕНИЯ')]")).click();
    }

    public static void checkRoomTypes () {
        $$("#catalog_cat>div .cat_zag").shouldHaveSize(2).shouldHave(CollectionCondition.exactTexts(types));
    }

    public static void checkAndGetPictures() {
        $$("#catalog_cat a").forEach(element->picturesUrls.add(element.getAttribute("href")));
        System.out.println(picturesUrls);
    }

    public static void openChandelierPicturesList() {
        $(By.xpath("//*[contains(text(),'ЛЮСТРЫ И СВЕТИЛЬНИКИ')]")).click();
    }

    public static void checkAndGetColorsPictures() {
        $$("#catalog_cat a").forEach(element->picturesUrls2.add(element.getAttribute("href")));
        System.out.println(picturesUrls2);
    }

    public static void openColorCataloguePicturesList() {
        $(By.xpath("//*[contains(text(),'КАТАЛОГ ЦВЕТОВ И ФАКТУР')]")).click();
    }
}
