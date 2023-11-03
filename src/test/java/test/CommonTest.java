package test;

import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static com.codeborne.selenide.Selenide.*;
public class CommonTest {
    ///////////////////////// 1 block ////////////////////////////////////////
    @Test
    // 1
    void shouldBuyWithApprovedCardAndValidData() {
        MainPage mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getApprovedAuthInfo());
        mainPage.buttonContinue.click();
        mainPage.success();
    }
    @Test
        // 2
    void shouldCreditWithApprovedCardAndValidData() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonCredit.click();
        mainPage.validInfo(DataHelper.getApprovedAuthInfo());
        mainPage.buttonContinue.click();
        mainPage.success();
    }
    @Test
        // 3
    void shouldNotBuyWithDeclinedCardAndValidData() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getDeclinedAuthInfo());
        mainPage.buttonContinue.click();
        mainPage.error();
    }
    @Test
        // 4
    void shouldNotCreditWithDeclinedCardAndValidData() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        mainPage.buttonBuy.click();
        mainPage.validInfo(DataHelper.getDeclinedAuthInfo());
        mainPage.buttonContinue.click();
        mainPage.error();
    }
}