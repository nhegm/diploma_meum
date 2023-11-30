package test;

import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static com.codeborne.selenide.Selenide.*;
public class CreditTest {
    @BeforeEach
    void MainPageOpen() {
        open("http://localhost:8080", MainPage.class);
        MainPage.creditFill(DataHelper.getValidAuthInfo());
    }
    @Test   // 1
    void shouldNotCreditWithCardNumber15DigitsAndLetter() {
        MainPage.cardNumber1SignErase(DataHelper.generateRandomLetter());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 2
    void shouldNotCreditWithCardNumberEmpty() {
        MainPage.cardNumberCleanAndFill("");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 3
    void shouldNotCreditWithCardNumber1Space() {
        MainPage.cardNumberCleanAndFill(" ");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 4
    void shouldNotCreditWithCardNumber16Nulls() {
        MainPage.cardNumberCleanAndFill(DataHelper.getNullCardNumber());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 5
    void shouldNotCreditWithCardNumber15Digits() {
        MainPage.cardNumber1SignErase("");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 6
    void shouldNotCreditWithMonth1Digit() {
        MainPage.monthCleanAndFill(DataHelper.generateRandomDigit());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 7
    void shouldNotCreditWithMonthMoreThan12() {
        MainPage.monthCleanAndFill("13");
        MainPage.wrongData("Неверно указан срок действия карты");
    }
    @Test   // 8
    void shouldNotCreditWithMonthEmpty() {
        MainPage.monthCleanAndFill("");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 9
    void shouldNotCreditWithMonthWithSpace() {
        MainPage.monthCleanAndFill(" ");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 10
    void shouldNotCreditWithMonthWithTwoNulls() {
        MainPage.monthCleanAndFill("00");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 11
    void shouldNotCreditWithYearMoreThan5() {
        MainPage.yearCleanAndFill(DataHelper.generateInvalidYear(6));
        MainPage.wrongData("Неверно указан срок действия карты");
    }
    @Test   // 12
    void shouldNotCreditWithYearLessThanNow() {
        MainPage.yearCleanAndFill(DataHelper.generateInvalidYear(-1));
        MainPage.wrongData("Неверно указан срок действия карты");
    }
    @Test   // 13
    void shouldNotCreditWithYearWrongData() {
        MainPage.yearCleanAndFill(DataHelper.generateRandom3Letters());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 14
    void shouldNotCreditWithYearWithTwoNulls() {
        MainPage.yearCleanAndFill("00");
        MainPage.wrongData("Истёк срок действия карты");
    }
    @Test   // 15
    void shouldNotCreditWithYearWithSpace() {
        MainPage.yearCleanAndFill(" ");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 16
    void shouldNotCreditWithYearEmpty() {
        MainPage.yearCleanAndFill("");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 17
    void shouldNotCreditWithNameCyrillic() {
        MainPage.nameCleanAndFill("Привет Олег");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 18
    void shouldNotCreditWithNameInvalid() {
        MainPage.nameCleanAndFill(DataHelper.generateInvalidNameOfBothify());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 19
    void shouldNotCreditWithNameHalfCyrillic() {
        MainPage.nameCleanAndFill(DataHelper.generateInvalidNameWithRussian());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 20
    void shouldNotCreditWithNameWithSymbols() {
        MainPage.nameCleanAndFill(DataHelper.generateInvalidNameWithSomeSymbols());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 21
    void shouldNotCreditWithCVCWrongSymbol() {
        MainPage.codeCleanAndFill(DataHelper.generateWrongStringForCVC());
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 22
    void shouldNotCreditWithCVCWithSpace() {
        MainPage.codeCleanAndFill(" ");
        MainPage.wrongData("Неверный формат");
    }
    @Test   // 23
    void shouldNotCreditWithCVCEmpty() {
        MainPage.codeCleanAndFill("");
        MainPage.wrongData("Неверный формат");
    }
}
