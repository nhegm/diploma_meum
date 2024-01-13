package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static com.codeborne.selenide.Selenide.*;

public class BuyTest {
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

    @Test   // 1
    @Order(1)
    void shouldNotBuyWithCardNumber15DigitsAndLetter() {
        mainPage.buyFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumber15DigitsPlusSymbol();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 2
    @Order(2)
    void shouldNotBuyWithCardNumberEmpty() {
        mainPage.buyFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumberEmpty();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 3
    @Order(3)
    void shouldNotBuyWithCardNumber1Space() {
        mainPage.buyFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumber1Space();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 4
    @Order(4)
    void shouldNotBuyWithCardNumber16Nulls() {
        mainPage.buyFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumber16Nulls();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 5
    @Order(5)
    void shouldNotBuyWithCardNumber15Digits() {
        mainPage.buyFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumberLessThan15Digits();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 6
    @Order(6)
    void shouldNotBuyWithMonth1Digit() {
        mainPage.buyFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.month1Digit();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 7
    @Order(7)
    void shouldNotBuyWithMonthMoreThan12() {
        mainPage.buyFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.monthMoreThan12();
        mainPage.continueClick();
        mainPage.wrongData("Неверно указан срок действия карты");
    }

    @Test   // 8
    @Order(8)
    void shouldNotBuyWithMonthEmpty() {
        mainPage.buyFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.monthEmpty();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 9
    @Order(9)
    void shouldNotBuyWithMonthWithSpace() {
        mainPage.buyFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.month1Space();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 10
    @Order(10)
    void shouldNotBuyWithMonthWithTwoNulls() {
        mainPage.buyFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.month2Nulls();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 11
    @Order(11)
    void shouldNotBuyWithYearMoreThan5() {
        mainPage.buyFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.yearMoreThan5();
        mainPage.continueClick();
        mainPage.wrongData("Неверно указан срок действия карты");
    }

    @Test   // 12
    @Order(12)
    void shouldNotBuyWithYearLessThanNow() {
        mainPage.buyFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.yearLessThanMin();
        mainPage.continueClick();
        mainPage.wrongData("Истёк срок действия карты");
    }

    @Test   // 13
    @Order(13)
    void shouldNotBuyWithYearWrongData() {
        mainPage.buyFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.yearWithWrongSymbol();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 14
    @Order(14)
    void shouldNotBuyWithYearWithTwoNulls() {
        mainPage.buyFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.year2Nulls();
        mainPage.continueClick();
        mainPage.wrongData("Истёк срок действия карты");
    }

    @Test   // 15
    @Order(15)
    void shouldNotBuyWithYearWithSpace() {
        mainPage.buyFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.year1Space();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 16
    @Order(16)
    void shouldNotBuyWithYearEmpty() {
        mainPage.buyFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.yearEmpty();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 17
    @Order(17)
    void shouldNotBuyWithNameCyrillic() {
        mainPage.buyFillWithoutName(DataHelper.getValidAuthInfo());
        mainPage.nameRussian();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 18
    @Order(18)
    void shouldNotBuyWithNameInvalid() {
        mainPage.buyFillWithoutName(DataHelper.getValidAuthInfo());
        mainPage.nameInvalid();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 19
    @Order(19)
    void shouldNotBuyWithNameEnglishAndCyrillic() {
        mainPage.buyFillWithoutName(DataHelper.getValidAuthInfo());
        mainPage.nameEnglishAndRussian();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 20
    @Order(20)
    void shouldNotBuyWithNameWithSymbols() {
        mainPage.buyFillWithoutName(DataHelper.getValidAuthInfo());
        mainPage.nameInvalidWithSomeSymbols();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 21
    @Order(21)
    void shouldNotBuyWithCVCWrongSymbol() {
        mainPage.buyFillWithoutCode(DataHelper.getValidAuthInfo());
        mainPage.code2NumbersWithSymbol();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 22
    @Order(22)
    void shouldNotBuyWithCVCWithSpace() {
        mainPage.buyFillWithoutCode(DataHelper.getValidAuthInfo());
        mainPage.code1Space();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 23
    @Order(23)
    void shouldNotBuyWithCVCEmpty() {
        mainPage.buyFillWithoutCode(DataHelper.getValidAuthInfo());
        mainPage.codeEmpty();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }
}
