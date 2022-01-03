package ru.netology;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.netology.util.DataGenerate;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.util.DataGenerate.generateDate;

public class CardDeliveryChangeDateTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    public void shouldSetForm() {

        String planningDate = generateDate(3);
        String planningDate2 = generateDate(7);

        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue(DataGenerate.generateCity());
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue(DataGenerate.generateName());
        $("[data-test-id='phone'] input").setValue(DataGenerate.generatePhone());
        $(".checkbox__box").click();
        $("[type='button'] [class=button__text]").click();
        $("[class='notification__content']").shouldBe(visible).shouldHave(text("Успешно")).shouldHave(text("Встреча успешно запланирована на " + planningDate));

        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate2);
        $("[type='button'] [class=button__text]").click();
        $("[data-test-id='replan-notification'] [class='notification__content']").shouldBe(visible, Duration.ofSeconds(20)).shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать?"));
        $("[data-test-id='replan-notification'] [class=button__text]").shouldHave(text("Перепланировать")).click();
        $("[data-test-id='success-notification'] [class='notification__title']").shouldBe(visible, Duration.ofSeconds(20)).shouldHave(text("Успешно"));
        $("[data-test-id='success-notification'] [class='notification__content']").shouldBe(visible, Duration.ofSeconds(20)).shouldHave(text("Встреча успешно запланирована на " + planningDate2));

    }

    @Test
    public void shouldSetForm2() {

        String planningDate = generateDate(10);
        String planningDate2 = generateDate(15);

        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue(DataGenerate.generateCity());
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue(DataGenerate.generateName());
        $("[data-test-id='phone'] input").setValue(DataGenerate.generatePhone());
        $(".checkbox__box").click();
        $("[type='button'] [class=button__text]").click();
        $("[class='notification__content']").shouldBe(visible).shouldHave(text("Успешно")).shouldHave(text("Встреча успешно запланирована на " + planningDate));

        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate2);
        $("[type='button'] [class=button__text]").click();
        $("[data-test-id='replan-notification'] [class='notification__content']").shouldBe(visible, Duration.ofSeconds(20)).shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать?"));
        $("[data-test-id='replan-notification'] [class=button__text]").shouldHave(text("Перепланировать")).click();
        $("[data-test-id='success-notification'] [class='notification__title']").shouldBe(visible, Duration.ofSeconds(20)).shouldHave(text("Успешно"));
        $("[data-test-id='success-notification'] [class='notification__content']").shouldBe(visible, Duration.ofSeconds(20)).shouldHave(text("Встреча успешно запланирована на " + planningDate2));
    }

    @Test
    public void shouldSetForm3() {

        String planningDate = generateDate(13);
        String planningDate2 = generateDate(7);

        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue(DataGenerate.generateCity());
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue(DataGenerate.generateName());
        $("[data-test-id='phone'] input").setValue(DataGenerate.generatePhone());
        $(".checkbox__box").click();
        $("[type='button'] [class=button__text]").click();
        $("[class='notification__content']").shouldBe(visible).shouldHave(text("Успешно")).shouldHave(text("Встреча успешно запланирована на " + planningDate));

        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate2);
        $("[type='button'] [class=button__text]").click();
        $("[data-test-id='replan-notification'] [class='notification__content']").shouldBe(visible, Duration.ofSeconds(20)).shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать?"));
        $("[data-test-id='replan-notification'] [class=button__text]").shouldHave(text("Перепланировать")).click();
        $("[data-test-id='success-notification'] [class='notification__title']").shouldBe(visible, Duration.ofSeconds(20)).shouldHave(text("Успешно"));
        $("[data-test-id='success-notification'] [class='notification__content']").shouldBe(visible, Duration.ofSeconds(20)).shouldHave(text("Встреча успешно запланирована на " + planningDate2));

    }
}
