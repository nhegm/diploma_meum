package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    public SelenideElement buttonBuy = $$(".button").get(0);
    public SelenideElement buttonCredit = $$(".button").get(1);
    public SelenideElement cardNumberField = $$(".input__control").get(0);
    public SelenideElement monthField = $$(".input__control").get(1);
    public SelenideElement yearField = $$(".input__control").get(2);
    public SelenideElement nameField = $$(".input__control").get(3);
    public SelenideElement codeField = $$(".input__control").get(4);
    public SelenideElement buttonContinue = $$(".button").get(2);
    public SelenideElement successNote = $$(".notification__title").get(0);
    public SelenideElement errorNote = $$(".notification__title").get(1);
    public SelenideElement substringMessage = $(".input__sub");
    private void fieldsFill(DataHelper.AuthInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        nameField.setValue(info.getCardHolder());
        codeField.setValue(info.getCVC());
    }

    public void validInfo(DataHelper.AuthInfo info) {
        fieldsFill(info);
    }

    public void success() {
        successNote.shouldHave(exactText("Успешно"), Duration.ofSeconds(10));
        successNote.shouldBe(visible);
    }

    public void error() {
        errorNote.shouldHave(exactText("Ошибка"), Duration.ofSeconds(10));
        errorNote.shouldBe(visible);
    }
    public void wrongFormat() {
        substringMessage.shouldHave(exactText("Неверный формат"));
    }
    public void wrongCardExpiration() {
        substringMessage.shouldHave(exactText("Неверно указан срок действия карты"));
    }
    public void cardExpired() {
        substringMessage.shouldHave(exactText("Истёк срок действия карты"));
    }
}