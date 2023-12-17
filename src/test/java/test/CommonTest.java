package test;

import data.DataHelper;
import data.SQLHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static com.codeborne.selenide.Selenide.*;

public class CommonTest {
    MainPage mainPage;

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
        SQLHelper.getOperationStatus().equals("DECLINED");
    }

    @Test
    // 2
    @Order(2)
    void shouldCreditWithApprovedCardAndValidData() {
        mainPage.creditFill(DataHelper.getApprovedAuthInfo());
        mainPage.continueClick();
        mainPage.success();
    }

    @Test
    // 3
    @Order(3)
    void shouldNotBuyWithDeclinedCardAndValidData() {
        mainPage.buyFill(DataHelper.getDeclinedAuthInfo());
        mainPage.continueClick();
        mainPage.error();
    }

    @Test
    // 4
    @Order(4)
    void shouldNotCreditWithDeclinedCardAndValidData() {
        mainPage.creditFill(DataHelper.getDeclinedAuthInfo());
        mainPage.continueClick();
        mainPage.error();
    }
}