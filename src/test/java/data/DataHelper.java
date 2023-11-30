package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
    public static String generateValidMonth(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }
    public static String generateValidYear(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("YY"));
    }
    public static String generateRandom3Letters() {
        return faker.letterify("???");
    }
    public static String generateRandomLetter() {
        return faker.letterify("?");
    }
    public static String generateRandomDigit() {
        return faker.numerify("#");
    }
    public static String generateInvalidYear(Integer plusYear) {
        return LocalDate.now().plusYears(plusYear).format(DateTimeFormatter.ofPattern("YY"));
    }
    public static String generateWrongStringForCVC() {
        return faker.letterify("58?");
    }
    public static String generateInvalidNameOfBothify() {
        return faker.bothify("4O???%)??30d?");
    }
    public static String generateInvalidNameWithRussian() {
        return faker.name().firstName() + ' ' + "Алексий";
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
        return new AuthInfo (cardNumber, month, year, cardHolder, CVC);
    }
    public static AuthInfo getApprovedAuthInfo() {
        String cardNumber = getApprovedCardNumber();
        String month = generateValidMonth();
        String year = generateValidYear();
        String cardHolder = generateValidName();
        String CVC = generateValidCVC();

        return new AuthInfo (cardNumber, month, year, cardHolder, CVC);
    }

    public static AuthInfo getDeclinedAuthInfo() {
        String cardNumber = getDeclinedCardNumber();
        String year = generateValidYear();
        String month = generateValidMonth();
        String cardHolder = generateValidName();
        String CVC = generateValidCVC();

        return new AuthInfo (cardNumber, month, year, cardHolder, CVC);
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
