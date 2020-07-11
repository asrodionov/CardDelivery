package ru.netology.domain;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {

    @Test
    void shouldCardDeliverySubmit() {

        DateDelivery manager = new DateDelivery();
        String date = manager.dateDeliveryCalculate(3);

        open("http://localhost:9999/");
        SelenideElement form = $("form");
        form.$("[data-test-id=city] input").setValue("Санкт-Петербург");
        form.$("[data-test-id=date] input").sendKeys(Keys.CONTROL + "a");
        form.$("[data-test-id=date] input").sendKeys(Keys.DELETE);
        form.$("[data-test-id=date] input").setValue(date);
        form.$("[data-test-id=name] input").setValue("Родионов Андрей");
        form.$("[data-test-id=phone] input").setValue("+79059384079");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=notification]").waitUntil(visible,15000);
        $("[data-test-id=notification]  .notification__title").shouldHave(exactText("Успешно!"));
        $("[data-test-id=notification]  .notification__content").shouldHave(exactText("Встреча успешно забронирована на "+date));
    }
}
