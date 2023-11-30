package test;

import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static com.codeborne.selenide.Selenide.*;
public class BuyTest {
    @BeforeEach
    void MainPageOpen() {
        open("http://localhost:8080", MainPage.class);
        MainPage.buyFill(DataHelper.getValidAuthInfo());
    }
    @Test   // 1
    void shouldNotBuyWithCardNumber15DigitsAndLetter() {
        MainPage.cardNumber1SignErase(DataHelper.generateRandomLetter());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 2
    void shouldNotBuyWithCardNumberEmpty() {
        MainPage.cardNumberCleanAndFill("");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 3
    void shouldNotBuyWithCardNumber1Space() {
        MainPage.cardNumberCleanAndFill(" ");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 4
    void shouldNotBuyWithCardNumber16Nulls() {
        MainPage.cardNumberCleanAndFill(DataHelper.getNullCardNumber());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 5
    void shouldNotBuyWithCardNumber15Digits() {
        MainPage.cardNumber1SignErase("");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 6
    void shouldNotBuyWithMonth1Digit() {
        MainPage.monthCleanAndFill(DataHelper.generateRandomDigit());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 7
    void shouldNotBuyWithMonthMoreThan12() {
        MainPage.monthCleanAndFill("13");
        MainPage.wrongData("Неверно указан срок действия карты");
    }
    @Test   // 8
    void shouldNotBuyWithMonthEmpty() {
        MainPage.monthCleanAndFill("");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 9
    void shouldNotBuyWithMonthWithSpace() {
        MainPage.monthCleanAndFill(" ");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 10
    void shouldNotBuyWithMonthWithTwoNulls() {
        MainPage.monthCleanAndFill("00");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 11
    void shouldNotBuyWithYearMoreThan5() {
        MainPage.yearCleanAndFill(DataHelper.generateInvalidYear(6));
        MainPage.wrongData("Неверно указан срок действия карты");
    }
    @Test   // 12
    void shouldNotBuyWithYearLessThanNow() {
        MainPage.yearCleanAndFill(DataHelper.generateInvalidYear(-1));
        MainPage.wrongData("Неверно указан срок действия карты");
    }
    @Test   // 13
    void shouldNotBuyWithYearWrongData() {
        MainPage.yearCleanAndFill(DataHelper.generateRandom3Letters());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 14
    void shouldNotBuyWithYearWithTwoNulls() {
        MainPage.yearCleanAndFill("00");
        MainPage.wrongData("Истёк срок действия карты");
    }
    @Test   // 15
    void shouldNotBuyWithYearWithSpace() {
        MainPage.yearCleanAndFill(" ");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 16
    void shouldNotBuyWithYearEmpty() {
        MainPage.yearCleanAndFill("");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 17
    void shouldNotBuyWithNameCyrillic() {
        MainPage.nameCleanAndFill("Привет Олег");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 18
    void shouldNotBuyWithNameInvalid() {
        MainPage.nameCleanAndFill(DataHelper.generateInvalidNameOfBothify());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 19
    void shouldNotBuyWithNameHalfCyrillic() {
        MainPage.nameCleanAndFill(DataHelper.generateInvalidNameWithRussian());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 20
    void shouldNotBuyWithNameWithSymbols() {
        MainPage.nameCleanAndFill(DataHelper.generateInvalidNameWithSomeSymbols());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 21
    void shouldNotBuyWithCVCWrongSymbol() {
        MainPage.codeCleanAndFill(DataHelper.generateWrongStringForCVC());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 22
    void shouldNotBuyWithCVCWithSpace() {
        MainPage.codeCleanAndFill(" ");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 23
    void shouldNotBuyWithCVCEmpty() {
        MainPage.codeCleanAndFill("");
        MainPage.wrongData("Неверный формат");
    }
}
