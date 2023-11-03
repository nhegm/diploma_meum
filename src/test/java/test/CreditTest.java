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
        mainPage.cardNumberField.sendKeys("g");
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 2
    void shouldNotCreditWithCardNumberEmpty() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        for (int i = 0; i < 16; i++)
            mainPage.cardNumberField.sendKeys(Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 3
    void shouldNotCreditWithCardNumber1Space() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        for (int i = 0; i < 16; i++)
            mainPage.cardNumberField.sendKeys(Keys.BACK_SPACE);
        mainPage.cardNumberField.setValue("5");
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 4
    void shouldNotCreditWithCardNumber16Nulls() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        for (int i = 0; i < 16; i++)
            mainPage.cardNumberField.sendKeys(Keys.BACK_SPACE);
        mainPage.cardNumberField.setValue("0000000000000000");
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 5
    void shouldNotCreditWithCardNumber15Digits() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.cardNumberField.sendKeys(Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 6
    void shouldNotCreditWithMonth1Digit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.ARROW_LEFT,Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 7
    void shouldNotCreditWithMonthMoreThan12() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.monthField.setValue("13");
        mainPage.buttonContinue.click();
        mainPage.wrongCardExpiration();
    }
    @Test   // 8
    void shouldNotCreditWithMonthEmpty() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 9
    void shouldNotCreditWithMonthWithSpace() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.monthField.setValue(" ");
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 10
    void shouldNotCreditWithMonthWithTwoNulls() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.monthField.setValue("00");
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 11
    void shouldNotCreditWithYearMoreThan5() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue("29");
        mainPage.buttonContinue.click();
        mainPage.wrongCardExpiration();
    }
    @Test   // 12
    void shouldNotCreditWithYearLessThanNow() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue("21");
        mainPage.buttonContinue.click();
        mainPage.wrongCardExpiration();
    }
    @Test   // 13
    void shouldNotCreditWithYearWrongData() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue("go");
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 14
    void shouldNotCreditWithYearWithTwoNulls() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue("00");
        mainPage.buttonContinue.click();
        mainPage.cardExpired();
    }
    @Test   // 15
    void shouldNotCreditWithYearWithSpace() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue(" ");
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 16
    void shouldNotCreditWithYearEmpty() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 17
    void shouldNotCreditWithNameCyrillic() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        for (int i = 0; i < 30; i++)
            mainPage.nameField.sendKeys(Keys.BACK_SPACE);
        mainPage.nameField.setValue("Привет Олег");
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 18
    void shouldNotCreditWithNameInvalid() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        for (int i = 0; i < 30; i++)
            mainPage.nameField.sendKeys(Keys.BACK_SPACE);
        mainPage.nameField.setValue("PO40kcvmk4N_39)");
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 19
    void shouldNotCreditWithNameHalfCyrillic() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        for (int i = 0; i < 30; i++)
            mainPage.nameField.sendKeys(Keys.BACK_SPACE);
        mainPage.nameField.setValue("Ben Дурак");
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 20
    void shouldNotCreditWithNameWithSymbols() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        for (int i = 0; i < 30; i++)
            mainPage.nameField.sendKeys(Keys.BACK_SPACE);
        mainPage.nameField.setValue("Ben, *");
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 21
    void shouldNotCreditWithCVCWrongSymbol() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.codeField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        mainPage.codeField.setValue("54h");
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 22
    void shouldNotCreditWithCVCWithSpace() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.codeField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        mainPage.codeField.setValue(" ");
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
    @Test   // 23
    void shouldNotCreditWithCVCEmpty() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.codeField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        mainPage.codeField.setValue("");
        mainPage.buttonContinue.click();
        mainPage.wrongFormat();
    }
}
