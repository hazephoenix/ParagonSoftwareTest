package BaseClasses.uii.pageModel;

import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class PriceListPage {

    private static final List<String> tableRawsValues = Arrays.asList("Что входит Другие компании «Потолкоff58»", "Полотно  \u2714   \u2714", "Монтаж -  \u2714", "Разводка электричества -  \u2714", "Выезд замерщика  \u2714  \u2714", "Доставка бригады и материалов -  \u2714");


    public static void checkHeader() {
        $(By.xpath("//span[text()='Цены на натяжные потолки']")).shouldBe(visible);
    }

    public static void checkTableValues() {
        $$(By.xpath("(//tbody)[1]/tr")).shouldHave(CollectionCondition.texts(tableRawsValues));
    }

    public static void openCalcForm() {
        $(By.xpath("//*[contains (text(),'Онлан-калькулятор')]")).click();
    }
}
