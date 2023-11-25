package test;

import data.DataHelper;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import page.MainPage;

import static com.codeborne.selenide.Selenide.*;
public class CreditTest {
    @Test   // 1
    void shouldNotCreditWithCardNumber15DigitsAndLetter() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.cardNumberField.sendKeys(Keys.BACK_SPACE);
        mainPage.cardNumberField.setValue(DataHelper.generateRandom3Letters());
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 2
    void shouldNotCreditWithCardNumberEmpty() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.cardNumberField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mainPage.cardNumberField.sendKeys(Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 3
    void shouldNotCreditWithCardNumber1Space() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.cardNumberField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mainPage.cardNumberField.sendKeys(Keys.BACK_SPACE);
        mainPage.cardNumberField.setValue(" ");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 4
    void shouldNotCreditWithCardNumber16Nulls() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.cardNumberField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mainPage.cardNumberField.sendKeys(Keys.BACK_SPACE);
        mainPage.cardNumberField.setValue("0000000000000000");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 5
    void shouldNotCreditWithCardNumber15Digits() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.cardNumberField.sendKeys(Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 6
    void shouldNotCreditWithMonth1Digit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.ARROW_LEFT,Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 7
    void shouldNotCreditWithMonthMoreThan12() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.monthField.setValue("13");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверно указан срок действия карты");
    }
    @Test   // 8
    void shouldNotCreditWithMonthEmpty() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 9
    void shouldNotCreditWithMonthWithSpace() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.monthField.setValue(" ");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 10
    void shouldNotCreditWithMonthWithTwoNulls() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.monthField.setValue("00");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 11
    void shouldNotCreditWithYearMoreThan5() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue(DataHelper.generateInvalidYear(7));
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверно указан срок действия карты");
    }
    @Test   // 12
    void shouldNotCreditWithYearLessThanNow() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue(DataHelper.generateInvalidYear(6));
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверно указан срок действия карты");
    }
    @Test   // 13
    void shouldNotCreditWithYearWrongData() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue(DataHelper.generateRandom3Letters());
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 14
    void shouldNotCreditWithYearWithTwoNulls() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue("00");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Истёк срок действия карты");
    }
    @Test   // 15
    void shouldNotCreditWithYearWithSpace() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue(" ");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 16
    void shouldNotCreditWithYearEmpty() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 17
    void shouldNotCreditWithNameCyrillic() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.nameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mainPage.nameField.sendKeys(Keys.BACK_SPACE);
        mainPage.nameField.setValue("Привет Олег");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 18
    void shouldNotCreditWithNameInvalid() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.nameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mainPage.nameField.sendKeys(Keys.BACK_SPACE);
        mainPage.nameField.setValue(DataHelper.generateInvalidNameOfBothify());
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 19
    void shouldNotCreditWithNameHalfCyrillic() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.nameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mainPage.nameField.sendKeys(Keys.BACK_SPACE);
        mainPage.nameField.setValue(DataHelper.generateInvalidNameWithRussian());
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 20
    void shouldNotCreditWithNameWithSymbols() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.nameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mainPage.nameField.sendKeys(Keys.BACK_SPACE);
        mainPage.nameField.setValue(DataHelper.generateInvalidNameWithSomeSymbols());
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 21
    void shouldNotCreditWithCVCWrongSymbol() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.codeField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        mainPage.codeField.setValue(DataHelper.generateWrongStringForCVC());
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 22
    void shouldNotCreditWithCVCWithSpace() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.codeField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        mainPage.codeField.setValue(" ");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 23
    void shouldNotCreditWithCVCEmpty() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.codeField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        mainPage.codeField.setValue("");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
}
