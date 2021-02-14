package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
//import org.w3c.dom.CDATASection;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//import java.util.Locale;

class OrderApiTestV1 {
    @Test
    void shouldHappyPath() {

        open("http://localhost:9999");
        // SelenideElement form =
        SelenideElement form = $("form");
        $("[data-test-id='name'] input").setValue("Иванов Иван"); //фаминиляя и имя
        $("[data-test-id='phone'] input").setValue("+12345678901"); //телефон
        $("[data-test-id=agreement]").click();//флажок согласия
        $("[type='button']").click();//кн продолжить
        $("[data-test-id='order-success']")
                .shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
