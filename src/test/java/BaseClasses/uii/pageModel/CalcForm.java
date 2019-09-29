package BaseClasses.uii.pageModel;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;


public class CalcForm {

    private static String expectedCostValue = "Цена: 9778 руб.";
    private static SelenideElement calc = $("#calc");


    public static void calculateAndCheck() {
        $("h1[style]").shouldBe(visible);
        calc.$("#sel_par").selectOption(2);
        calc.$("#check2").setSelected(true);
        calc.$("input[name=param3]").setValue("4");
        calc.$("#check3").setSelected(true);
        if (calc.$("#check3").isSelected()) {
            calc.$("input[name=param5]").setValue("3");
        }
        calc.$("input[name=param6]").setValue("1");
        calc.$("input[name=param7]").setValue("5");
        calc.$("input[name=param8]").setValue("2");
        calc.$("input[name=param9]").setValue("7");
        calc.$("input[name=param10]").setValue("8");
        calc.$("#check6").setSelected(true);
        calc.$("#submit_but").click();
        assertThat(calc.$("#itogo").getText()).isEqualTo(expectedCostValue);
    }
}
