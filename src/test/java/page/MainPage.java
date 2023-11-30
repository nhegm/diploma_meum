package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import data.DataHelper;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private static SelenideElement buttonBuy = $$(".button").get(0);
    private static SelenideElement buttonCredit = $$(".button").get(1);
    private static SelenideElement cardNumberField = $$(".input__control").get(0);
    private static SelenideElement monthField = $$(".input__control").get(1);
    private static SelenideElement yearField = $$(".input__control").get(2);
    private static SelenideElement nameField = $$(".input__control").get(3);
    private static SelenideElement codeField = $$(".input__control").get(4);
    private static SelenideElement buttonContinue = $$(".button").get(2);
    private static SelenideElement successNote = $$(".notification__title").get(0);
    private static SelenideElement errorNote = $$(".notification__title").get(1);
    private static SelenideElement substringMessage = $(".input__sub");
    private static void fieldsFill(DataHelper.AuthInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        nameField.setValue(info.getCardHolder());
        codeField.setValue(info.getCVC());
    }
    public static void buyFill(DataHelper.AuthInfo info){
        buttonBuy.click();
        fieldsFill(info);
    }
    public static void creditFill(DataHelper.AuthInfo info){
        buttonCredit.click();
        fieldsFill(info);
    }
    public static void continueClick() {
        buttonContinue.click();
    }
    public static void cardNumberCleanAndFill(String value){
        cardNumberField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        cardNumberField.sendKeys(Keys.BACK_SPACE);
        cardNumberField.setValue(value);
        buttonContinue.click();
    }
    public static void cardNumber1SignErase(String value){
        cardNumberField.sendKeys(Keys.BACK_SPACE);
        cardNumberField.setValue(value);
        buttonContinue.click();
    }
    public static void monthCleanAndFill(String value){
        monthField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);
        monthField.setValue(value);
        buttonContinue.click();
    }
    public static void yearCleanAndFill(String value){
        yearField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);
        yearField.setValue(value);
        buttonContinue.click();
    }
    public static void nameCleanAndFill(String value){
        nameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        nameField.sendKeys(Keys.BACK_SPACE);
        nameField.setValue(value);
        buttonContinue.click();
    }
    public static void codeCleanAndFill(String value){
        codeField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        codeField.sendKeys(Keys.BACK_SPACE);
        codeField.setValue(value);
        buttonContinue.click();
    }
    public static void success() {
        successNote.shouldHave(exactText("Успешно"), Duration.ofSeconds(10));
        successNote.shouldBe(visible);
    }
    public static void error() {
        errorNote.shouldHave(exactText("Ошибка"), Duration.ofSeconds(10));
        errorNote.shouldBe(visible);
    }
    public static void wrongData(String subsMessage) {
        substringMessage.shouldHave(exactText(subsMessage), Duration.ofSeconds(10));
        substringMessage.shouldBe(visible);
    }
}