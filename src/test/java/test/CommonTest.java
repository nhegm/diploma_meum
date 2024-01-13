package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import data.SQLHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import page.MainPage;

import static com.codeborne.selenide.Selenide.*;

public class CommonTest {
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
    @Order(1)
    void shouldBuyWithApprovedCardAndValidData() {
        mainPage.buyFill(DataHelper.getApprovedAuthInfo());
        mainPage.continueClick();
        mainPage.success();
        Assertions.assertEquals(SQLHelper.getBuyStatus(),"APPROVED");
    }

    @Test
    // 2
    @Order(2)
    void shouldCreditWithApprovedCardAndValidData() {
        mainPage.creditFill(DataHelper.getApprovedAuthInfo());
        mainPage.continueClick();
        mainPage.success();
        Assertions.assertEquals(SQLHelper.getCreditStatus(),"APPROVED");
    }

    @Test
    // 3
    @Order(3)
    void shouldNotBuyWithDeclinedCardAndValidData() {
        mainPage.buyFill(DataHelper.getDeclinedAuthInfo());
        mainPage.continueClick();
        mainPage.error();
        Assertions.assertEquals(SQLHelper.getBuyStatus(),"DECLINED");
    }

    @Test
    // 4
    @Order(4)
    void shouldNotCreditWithDeclinedCardAndValidData() {
        mainPage.creditFill(DataHelper.getDeclinedAuthInfo());
        mainPage.continueClick();
        mainPage.error();
        Assertions.assertEquals(SQLHelper.getCreditStatus(),"DECLINED");
    }
}