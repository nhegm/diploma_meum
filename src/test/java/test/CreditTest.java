package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static com.codeborne.selenide.Selenide.*;

public class CreditTest {
    MainPage mainPage;
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
    @BeforeEach
    void mainPageOpen() {
        mainPage = open("http://localhost:8080", MainPage.class);
    }

    @Test
        // 1
    void shouldNotCreditWithCardNumber15DigitsAndLetter() {
        mainPage.creditFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumber15DigitsPlusSymbol();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 2
    void shouldNotCreditWithCardNumberEmpty() {
        mainPage.creditFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumberEmpty();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 3
    void shouldNotCreditWithCardNumber1Space() {
        mainPage.creditFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumber1Space();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 4
    void shouldNotCreditWithCardNumber16Nulls() {
        mainPage.creditFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumber16Nulls();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 5
    void shouldNotCreditWithCardNumber15Digits() {
        mainPage.creditFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumberLessThan15Digits();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 6
    void shouldNotCreditWithMonth1Digit() {
        mainPage.creditFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.month1Digit();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 7
    void shouldNotCreditWithMonthMoreThan12() {
        mainPage.creditFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.monthMoreThan12();
        mainPage.continueClick();
        mainPage.wrongData("Неверно указан срок действия карты");
    }

    @Test
        // 8
    void shouldNotCreditWithMonthEmpty() {
        mainPage.creditFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.monthEmpty();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 9
    void shouldNotCreditWithMonthWithSpace() {
        mainPage.creditFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.month1Space();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 10
    void shouldNotCreditWithMonthWithTwoNulls() {
        mainPage.creditFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.month2Nulls();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 11
    void shouldNotCreditWithYearMoreThan5() {
        mainPage.creditFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.yearMoreThan5();
        mainPage.continueClick();
        mainPage.wrongData("Неверно указан срок действия карты");
    }

    @Test
        // 12
    void shouldNotCreditWithYearLessThanNow() {
        mainPage.creditFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.yearLessThanMin();
        mainPage.continueClick();
        mainPage.wrongData("Истёк срок действия карты");
    }

    @Test
        // 13
    void shouldNotCreditWithYearWrongData() {
        mainPage.creditFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.yearWithWrongSymbol();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 14
    void shouldNotCreditWithYearWithTwoNulls() {
        mainPage.creditFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.year2Nulls();
        mainPage.continueClick();
        mainPage.wrongData("Истёк срок действия карты");
    }

    @Test
        // 15
    void shouldNotCreditWithYearWithSpace() {
        mainPage.creditFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.year1Space();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 16
    void shouldNotCreditWithYearEmpty() {
        mainPage.creditFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.yearEmpty();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 17
    void shouldNotCreditWithNameCyrillic() {
        mainPage.creditFillWithoutName(DataHelper.getValidAuthInfo());
        mainPage.nameRussian();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 18
    void shouldNotCreditWithNameInvalid() {
        mainPage.creditFillWithoutName(DataHelper.getValidAuthInfo());
        mainPage.nameInvalid();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 19
    void shouldNotCreditWithNameEnglishAndCyrillic() {
        mainPage.creditFillWithoutName(DataHelper.getValidAuthInfo());
        mainPage.nameEnglishAndRussian();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 20
    void shouldNotCreditWithNameWithSymbols() {
        mainPage.creditFillWithoutName(DataHelper.getValidAuthInfo());
        mainPage.nameInvalidWithSomeSymbols();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 21
    void shouldNotCreditWithCVCWrongSymbol() {
        mainPage.creditFillWithoutCode(DataHelper.getValidAuthInfo());
        mainPage.code2NumbersWithSymbol();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 22
    void shouldNotCreditWithCVCWithSpace() {
        mainPage.creditFillWithoutCode(DataHelper.getValidAuthInfo());
        mainPage.code1Space();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test
        // 23
    void shouldNotCreditWithCVCEmpty() {
        mainPage.creditFillWithoutCode(DataHelper.getValidAuthInfo());
        mainPage.codeEmpty();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }
}
