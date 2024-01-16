package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import data.DataHelper;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement buttonBuy = $$(".button").get(0);
    private SelenideElement buttonCredit = $$(".button").get(1);
    private SelenideElement cardNumberField = $$(".input__control").get(0);
    private SelenideElement monthField = $$(".input__control").get(1);
    private SelenideElement yearField = $$(".input__control").get(2);
    private SelenideElement nameField = $$(".input__control").get(3);
    private SelenideElement codeField = $$(".input__control").get(4);
    private SelenideElement buttonContinue = $$(".button").get(2);
    private SelenideElement successNote = $$(".notification__title").get(0);
    private SelenideElement errorNote = $$(".notification__title").get(0);
    private SelenideElement substringMessage = $(".input__sub");

    private void fieldsFill(DataHelper.AuthInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        nameField.setValue(info.getCardHolder());
        codeField.setValue(info.getCVC());
    }

    private void fieldsFillWithoutNumber(DataHelper.AuthInfo info) {
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        nameField.setValue(info.getCardHolder());
        codeField.setValue(info.getCVC());
    }

    private void fieldsFillWithoutMonth(DataHelper.AuthInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        yearField.setValue(info.getYear());
        nameField.setValue(info.getCardHolder());
        codeField.setValue(info.getCVC());
    }

    private void fieldsFillWithoutYear(DataHelper.AuthInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        nameField.setValue(info.getCardHolder());
        codeField.setValue(info.getCVC());
    }

    private void fieldsFillWithoutName(DataHelper.AuthInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        codeField.setValue(info.getCVC());
    }

    private void fieldsFillWithoutCode(DataHelper.AuthInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        nameField.setValue(info.getCardHolder());
    }

    public void buttonBuyClick() {
        buttonBuy.click();
    }

    public void buttonCreditClick() {
        buttonCredit.click();
    }

    public void buyFill(DataHelper.AuthInfo info) {
        buttonBuy.click();
        fieldsFill(info);
    }

    public void buyFillWithoutNumber(DataHelper.AuthInfo info) {
        buttonBuy.click();
        fieldsFillWithoutNumber(info);
    }

    public void buyFillWithoutMonth(DataHelper.AuthInfo info) {
        buttonBuy.click();
        fieldsFillWithoutMonth(info);
    }

    public void buyFillWithoutYear(DataHelper.AuthInfo info) {
        buttonBuy.click();
        fieldsFillWithoutYear(info);
    }

    public void buyFillWithoutName(DataHelper.AuthInfo info) {
        buttonBuy.click();
        fieldsFillWithoutName(info);
    }

    public void buyFillWithoutCode(DataHelper.AuthInfo info) {
        buttonBuy.click();
        fieldsFillWithoutCode(info);
    }

    public void creditFill(DataHelper.AuthInfo info) {
        buttonCredit.click();
        fieldsFill(info);
    }

    public void creditFillWithoutNumber(DataHelper.AuthInfo info) {
        buttonCredit.click();
        fieldsFillWithoutNumber(info);
    }

    public void creditFillWithoutMonth(DataHelper.AuthInfo info) {
        buttonCredit.click();
        fieldsFillWithoutMonth(info);
    }

    public void creditFillWithoutYear(DataHelper.AuthInfo info) {
        buttonCredit.click();
        fieldsFillWithoutYear(info);
    }

    public void creditFillWithoutName(DataHelper.AuthInfo info) {
        buttonCredit.click();
        fieldsFillWithoutName(info);
    }

    public void creditFillWithoutCode(DataHelper.AuthInfo info) {
        buttonCredit.click();
        fieldsFillWithoutCode(info);
    }

    public void continueClick() {
        buttonContinue.click();
    }

    public void cardNumber15DigitsPlusSymbol() {
        cardNumberField.setValue(DataHelper.generateCardNumber15DigitPlusSymbol());
    }

    public void cardNumberEmpty() {
        cardNumberField.setValue("");
    }

    public void cardNumber1Space() {
        cardNumberField.setValue(" ");
    }

    public void cardNumber16Nulls() {
        cardNumberField.setValue(DataHelper.getNullCardNumber());
    }

    public void cardNumberLessThan15Digits() {
        cardNumberField.setValue(DataHelper.generateCardNumberLessThan16Digits());
    }

    public void month1Digit() {
        monthField.setValue(DataHelper.generateMonth1Digit());
    }

    public void monthMoreThan12() {
        monthField.setValue(DataHelper.generateMonthMoreThan12());
    }

    public void monthEmpty() {
        monthField.setValue(DataHelper.generateMonthEmpty());
    }

    public void month1Space() {
        monthField.setValue(DataHelper.generateMonth1Space());
    }

    public void month2Nulls() {
        monthField.setValue(DataHelper.generateMonth2Nulls());
    }

    public void yearMoreThan5() {
        yearField.setValue(DataHelper.generateYearMoreThan5());
    }

    public void yearLessThanMin() {
        yearField.setValue(DataHelper.generateYearLessThanMin());
    }

    public void yearWithWrongSymbol() {
        yearField.setValue(DataHelper.generateYearWithWrongSymbol());
    }

    public void year2Nulls() {
        yearField.setValue(DataHelper.generateYear2Nulls());
    }

    public void year1Space() {
        yearField.setValue(DataHelper.generateYear1Space());
    }

    public void yearEmpty() {
        yearField.setValue(DataHelper.generateYearEmpty());
    }

    public void nameRussian() {
        nameField.setValue(DataHelper.generateInvalidNameRussian());
    }

    public void nameInvalid() {
        nameField.setValue(DataHelper.generateInvalidNameWithSomeSymbols());
    }

    public void name1Space() {
        nameField.setValue(DataHelper.generateName1Space());
    }

    public void nameEmpty() {
        nameField.setValue(DataHelper.generateNameEmpty());
    }

    public void nameEnglishAndRussian() {
        nameField.setValue(DataHelper.generateInvalidNameEnglishAndRussian());
    }

    public void code2NumbersWithSymbol() {
        codeField.setValue(DataHelper.generateCVC2NumbersWithSymbol());
    }

    public void codeEmpty() {
        codeField.setValue(DataHelper.generateCVCEmpty());
    }

    public void code1Space() {
        codeField.setValue(DataHelper.generateCVC1Space());
    }

    public void success() {
        successNote.shouldHave(exactText("Успешно"), Duration.ofSeconds(20));
        successNote.shouldBe(visible);
    }

    public void error() {
        errorNote.shouldHave(exactText("Ошибка"), Duration.ofSeconds(20));
        errorNote.shouldBe(visible);
    }

    public void wrongData(String subsMessage) {
        substringMessage.shouldHave(exactText(subsMessage));
        substringMessage.shouldBe(visible);
    }
}