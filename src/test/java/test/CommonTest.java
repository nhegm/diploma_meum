package test;

import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static com.codeborne.selenide.Selenide.*;
public class CommonTest {
    @BeforeEach
    void MainPageOpen() {
        open("http://localhost:8080", MainPage.class);
    }
    @Test
    // 1
    void shouldBuyWithApprovedCardAndValidData() {
        MainPage.buyFill(DataHelper.getApprovedAuthInfo());
        MainPage.continueClick();
        MainPage.success();
    }
    @Test
        // 2
    void shouldCreditWithApprovedCardAndValidData() {
        MainPage.creditFill(DataHelper.getApprovedAuthInfo());
        MainPage.continueClick();
        MainPage.success();
    }
    @Test
        // 3
    void shouldNotBuyWithDeclinedCardAndValidData() {
        MainPage.buyFill(DataHelper.getDeclinedAuthInfo());
        MainPage.continueClick();
        MainPage.error();
    }
    @Test
        // 4
    void shouldNotCreditWithDeclinedCardAndValidData() {
        MainPage.creditFill(DataHelper.getDeclinedAuthInfo());
        MainPage.continueClick();
        MainPage.error();
    }
}