package test;

import data.DataHelper;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import page.MainPage;

import static com.codeborne.selenide.Selenide.*;
public class BuyTest {
    ///////////////////////// 1 block ////////////////////////////////////////
    @Test   // 1
    void shouldBuyWithApprovedCardAndValidData() {
        MainPage mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getApprovedAuthInfo());
        mainPage.buttonContinue.click();
        mainPage.success();
    }
    @Test   // 2
    void shouldCreditWithApprovedCardAndValidData() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getApprovedAuthInfo());
        mainPage.buttonContinue.click();
        mainPage.success();
    }
    @Test   // 3
    void shouldNotBuyWithDeclinedCardAndValidData() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getDeclinedAuthInfo());
        mainPage.buttonContinue.click();
        mainPage.error();
    }
    @Test   // 4
    void shouldNotCreditWithDeclinedCardAndValidData() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getDeclinedAuthInfo());
        mainPage.buttonContinue.click();
        mainPage.error();
    }
    ///////////////////////// 2 block ////////////////////////////////////////
    @Test   // 1
    void shouldNotBuyWithCardNumber15DigitsAndLetter() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.cardNumberField.sendKeys(Keys.BACK_SPACE);
        mainPage.cardNumberField.setValue(DataHelper.generateRandom3Letters());
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 2
    void shouldNotBuyWithCardNumberEmpty() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.cardNumberField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mainPage.cardNumberField.sendKeys(Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 3
    void shouldNotBuyWithCardNumber1Space() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.cardNumberField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mainPage.cardNumberField.sendKeys(Keys.BACK_SPACE);
        mainPage.cardNumberField.setValue(" ");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 4
    void shouldNotBuyWithCardNumber16Nulls() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.cardNumberField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mainPage.cardNumberField.sendKeys(Keys.BACK_SPACE);
        mainPage.cardNumberField.setValue("0000000000000000");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 5
    void shouldNotBuyWithCardNumber15Digits() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.cardNumberField.sendKeys(Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 6
    void shouldNotBuyWithMonth1Digit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.ARROW_LEFT,Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 7
    void shouldNotBuyWithMonthMoreThan12() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.monthField.setValue("13");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверно указан срок действия карты");
    }
    @Test   // 8
    void shouldNotBuyWithMonthEmpty() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 9
    void shouldNotBuyWithMonthWithSpace() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.monthField.setValue(" ");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 10
    void shouldNotBuyWithMonthWithTwoNulls() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.monthField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.monthField.setValue("00");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 11
    void shouldNotBuyWithYearMoreThan5() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue(DataHelper.generateInvalidYear(6));
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверно указан срок действия карты");
    }
    @Test   // 12
    void shouldNotBuyWithYearLessThanNow() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue(DataHelper.generateInvalidYear(9));
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверно указан срок действия карты");
    }
    @Test   // 13
    void shouldNotBuyWithYearWrongData() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue(DataHelper.generateRandom3Letters());
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 14
    void shouldNotBuyWithYearWithTwoNulls() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue("00");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Истёк срок действия карты");
    }
    @Test   // 15
    void shouldNotBuyWithYearWithSpace() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.yearField.setValue(" ");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 16
    void shouldNotBuyWithYearEmpty() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.yearField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 17
    void shouldNotBuyWithNameCyrillic() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.nameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mainPage.nameField.sendKeys(Keys.BACK_SPACE);
        mainPage.nameField.setValue("Привет Олег");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 18
    void shouldNotBuyWithNameInvalid() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.nameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mainPage.nameField.sendKeys(Keys.BACK_SPACE);
        mainPage.nameField.setValue(DataHelper.generateInvalidNameOfBothify());
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 19
    void shouldNotBuyWithNameHalfCyrillic() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.nameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mainPage.nameField.sendKeys(Keys.BACK_SPACE);
        mainPage.nameField.setValue(DataHelper.generateInvalidNameWithRussian());
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 20
    void shouldNotBuyWithNameWithSymbols() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.nameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mainPage.nameField.sendKeys(Keys.BACK_SPACE);
        mainPage.nameField.setValue(DataHelper.generateInvalidNameWithSomeSymbols());
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 21
    void shouldNotBuyWithCVCWrongSymbol() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.codeField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        mainPage.codeField.setValue(DataHelper.generateWrongStringForCVC());
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 22
    void shouldNotBuyWithCVCWithSpace() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.codeField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        mainPage.codeField.setValue(" ");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 23
    void shouldNotBuyWithCVCEmpty() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getValidAuthInfo());
        mainPage.codeField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        mainPage.codeField.setValue("");
        mainPage.buttonContinue.click();
        mainPage.wrongData("Неверный формат");
    }
}
