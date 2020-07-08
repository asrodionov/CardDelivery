import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {

    public class shouldCardDeliverySuccess {

        @Test
        void shouldCardOrderSubmit() {
            open("http://localhost:9999/");
            SelenideElement form = $("form");
            form.$("[data-test-id=name] input").setValue("Андрей");
            form.$("[data-test-id=phone] input").setValue("+79059384079");
            form.$("[data-test-id=agreement]").click();
            form.$("button").click();
            $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

        }
    }

}
