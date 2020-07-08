import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {

    @Test
    void shouldCardDeliverySubmit() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 3);
        date = c.getTime();

        open("http://localhost:9999/");
        SelenideElement form = $("form");
        form.$("[data-test-id=city] input").setValue("Санкт-Петербург");
        form.$("[data-test-id=date] input").sendKeys(Keys.CONTROL + "a");
        form.$("[data-test-id=date] input").sendKeys(Keys.DELETE);
        form.$("[data-test-id=date] input").setValue(formatter.format(date));
        form.$("[data-test-id=name] input").setValue("Родионов Андрей");
        form.$("[data-test-id=phone] input").setValue("+79059384079");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=notification]").waitUntil(visible,15000);
    }
}
