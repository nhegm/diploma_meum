package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataHelper {
    private DataHelper() {
    }

    public static final Faker faker = new Faker(new Locale("en"));

    public static String generateValidCardNumber() {
        return faker.numerify("#### #### #### ####");
    }

    public static String getApprovedCardNumber() {
        return new String("4444 4444 4444 4441");
    }

    public static String getDeclinedCardNumber() {
        return new String("4444 4444 4444 4442");
    }

    public static String getNullCardNumber() {
        return new String("0000 0000 0000 0000");
    }

    public static String generateCardNumber15DigitPlusSymbol() {
        return faker.numerify("#### #### #### ###") + faker.letterify("?");
    }

    public static String generateCardNumberLessThan16Digits() {
        String s = faker.numerify("################");
        Random rand = new Random();
        int bound = rand.nextInt(15) + 1;
        s = s.substring(0, s.length() - bound);
        return s;
    }

    public static String generateMonth1Digit() {
        Random rand = new Random();
        int month = rand.nextInt(9) + 1;
        return String.valueOf(month);
    }

    public static String generateMonthMoreThan12() {
        Random rand = new Random();
        int month = rand.nextInt(33) + 12;
        return String.valueOf(month);
    }

    public static String generateMonth1Space() {
        return " ";
    }

    public static String generateMonth2Nulls() {
        return "00";
    }

    public static String generateMonthEmpty() {
        return "";
    }

    public static String generateYearMoreThan5() {
        return LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("YY"));
    }

    public static String generateYearLessThanMin() {
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("YY"));
    }

    public static String generateYearWithWrongSymbol() {
        return faker.letterify("?");
    }

    public static String generateYear2Nulls() {
        return "00";
    }

    public static String generateYear1Space() {
        return " ";
    }

    public static String generateYearEmpty() {
        return "";
    }

    public static String generateValidMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateValidYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("YY"));
    }

    public static String generateInvalidNameRussian() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generateInvalidNameEnglishAndRussian() {
        String name = faker.name().firstName() + " ";
        Faker faker = new Faker(new Locale("ru"));
        name = name + faker.name().lastName();
        return name;
    }

    public static String generateCVC2NumbersWithSymbol() {
        return faker.bothify("##?");
    }

    public static String generateCVCEmpty() {
        return "";
    }

    public static String generateCVC1Space() {
        return " ";
    }

    public static String generateInvalidNameWithSomeSymbols() {
        return faker.name().firstName() + ' ' + "%(.";
    }

    public static String generateValidCVC() {
        return faker.numerify("###");
    }

    public static String generateValidName() {
        return faker.name().firstName() + ' ' + faker.name().lastName();
    }

    public static AuthInfo getValidAuthInfo() {
        String cardNumber = generateValidCardNumber();
        String month = generateValidMonth();
        String year = generateValidYear();
        String cardHolder = generateValidName();
        String CVC = generateValidCVC();
        return new AuthInfo(cardNumber, month, year, cardHolder, CVC);
    }

    public static AuthInfo getApprovedAuthInfo() {
        String cardNumber = getApprovedCardNumber();
        String month = generateValidMonth();
        String year = generateValidYear();
        String cardHolder = generateValidName();
        String CVC = generateValidCVC();

        return new AuthInfo(cardNumber, month, year, cardHolder, CVC);
    }

    public static AuthInfo getDeclinedAuthInfo() {
        String cardNumber = getDeclinedCardNumber();
        String year = generateValidYear();
        String month = generateValidMonth();
        String cardHolder = generateValidName();
        String CVC = generateValidCVC();

        return new AuthInfo(cardNumber, month, year, cardHolder, CVC);
    }

    @Value
    public static class AuthInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String cardHolder;
        private String CVC;
    }

}
