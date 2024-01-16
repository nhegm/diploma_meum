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

import java.time.Duration;

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
    void shouldNotBuyWithCardNumber15DigitsAndLetter() {
        mainPage.buyFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumber15DigitsPlusSymbol();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 2
    void shouldNotBuyWithCardNumberEmpty() {
        mainPage.buyFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumberEmpty();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 3
    void shouldNotBuyWithCardNumber1Space() {
        mainPage.buyFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumber1Space();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 4
    void shouldNotBuyWithCardNumber16Nulls() {
        mainPage.buyFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumber16Nulls();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
        Duration.ofSeconds(20);
    }

    @Test   // 5
    void shouldNotBuyWithCardNumber15Digits() {
        mainPage.buyFillWithoutNumber(DataHelper.getValidAuthInfo());
        mainPage.cardNumberLessThan15Digits();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 6
    void shouldNotBuyWithMonth1Digit() {
        mainPage.buyFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.month1Digit();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 7
    void shouldNotBuyWithMonthMoreThan12() {
        mainPage.buyFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.monthMoreThan12();
        mainPage.continueClick();
        mainPage.wrongData("Неверно указан срок действия карты");
    }

    @Test   // 8
    void shouldNotBuyWithMonthEmpty() {
        mainPage.buyFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.monthEmpty();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 9
    void shouldNotBuyWithMonthWithSpace() {
        mainPage.buyFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.month1Space();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 10
    void shouldNotBuyWithMonthWithTwoNulls() {
        mainPage.buyFillWithoutMonth(DataHelper.getValidAuthInfo());
        mainPage.month2Nulls();
        mainPage.continueClick();
        mainPage.wrongData("Неверно указан срок действия карты");
    }

    @Test   // 11
    void shouldNotBuyWithYearMoreThan5() {
        mainPage.buyFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.yearMoreThan5();
        mainPage.continueClick();
        mainPage.wrongData("Неверно указан срок действия карты");
    }

    @Test   // 12
    void shouldNotBuyWithYearLessThanNow() {
        mainPage.buyFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.yearLessThanMin();
        mainPage.continueClick();
        mainPage.wrongData("Истёк срок действия карты");
    }

    @Test   // 13
    void shouldNotBuyWithYearWrongData() {
        mainPage.buyFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.yearWithWrongSymbol();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 14
    void shouldNotBuyWithYearWithTwoNulls() {
        mainPage.buyFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.year2Nulls();
        mainPage.continueClick();
        mainPage.wrongData("Истёк срок действия карты");
    }

    @Test   // 15
    void shouldNotBuyWithYearWithSpace() {
        mainPage.buyFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.year1Space();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 16
    void shouldNotBuyWithYearEmpty() {
        mainPage.buyFillWithoutYear(DataHelper.getValidAuthInfo());
        mainPage.yearEmpty();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 17
    void shouldNotBuyWithName1Space() {
        mainPage.buyFillWithoutName(DataHelper.getValidAuthInfo());
        mainPage.name1Space();
        mainPage.continueClick();
        mainPage.wrongData("Поле обязательно для заполнения");
    }
    @Test   // 18
    void shouldNotBuyWithNameEnglishAndCyrillic() {
        mainPage.buyFillWithoutName(DataHelper.getValidAuthInfo());
        mainPage.nameEnglishAndRussian();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 19
    void shouldNotBuyWithNameInvalid() {
        mainPage.buyFillWithoutName(DataHelper.getValidAuthInfo());
        mainPage.nameInvalid();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }
    @Test   // 20
    void shouldNotBuyWithNameEmpty() {
        mainPage.buyFillWithoutName(DataHelper.getValidAuthInfo());
        mainPage.nameEmpty();
        mainPage.continueClick();
        mainPage.wrongData("Поле обязательно для заполнения");
    }
    @Test   // 21
    void shouldNotBuyWithCVCWrongSymbol() {
        mainPage.buyFillWithoutCode(DataHelper.getValidAuthInfo());
        mainPage.code2NumbersWithSymbol();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 22
    void shouldNotBuyWithCVCWith1Space() {
        mainPage.buyFillWithoutCode(DataHelper.getValidAuthInfo());
        mainPage.code1Space();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 23
    void shouldNotBuyWithCVCEmpty() {
        mainPage.buyFillWithoutCode(DataHelper.getValidAuthInfo());
        mainPage.codeEmpty();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }

    @Test   // 24
    void shouldNotBuyWithAllFieldsEmpty() {
        mainPage.buttonBuyClick();
        mainPage.continueClick();
        mainPage.wrongData("Неверный формат");
    }
}
