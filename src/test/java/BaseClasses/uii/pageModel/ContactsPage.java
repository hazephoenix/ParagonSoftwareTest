package BaseClasses.uii.pageModel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class ContactsPage {

    private static final SelenideElement form = $("#contactusForm");


    public static void checkHeader() {
        $("h1[style]").shouldBe(visible).shouldHave(exactText("Контакты"));
    }

    public static void proceedContactUsForm() {
        form.$("input[name=first_name]").setValue("nameExpample");
        form.$("input[name=email]").setValue("email@example.biz");
        form.$("textarea[name=text]").setValue("textSample");
        form.$(".divpol.calpol>input[type=checkbox").setSelected(true);
        form.$("#button").click();
    }
}
