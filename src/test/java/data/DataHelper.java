package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Calendar;
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
    public static String generateValidMonth(String year) {
        String [] monthArray = {"12", "11", "10", "09", "08", "07", "06", "05", "04", "03", "02", "01"};
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        Integer monthNumber = new Integer(0);
        if (year.equals("23")) {
            monthNumber = random.nextInt(monthArray.length - 10);
        } else {
            monthNumber = random.nextInt(monthArray.length);
        }
        return monthArray[monthNumber];
    }
    public static String generateValidYear() {
        String [] yearArray = {"23", "24", "25", "26", "27", "28"};
        Random random = new Random();
        int yearNumber = random.nextInt(yearArray.length);
        return yearArray[yearNumber];
    }
    public static String generateValidCVC() {
        return faker.numerify("###");
    }
    public static String generateValidName() {
        return faker.name().firstName() + ' ' + faker.name().lastName();
    }
    public static AuthInfo getValidAuthInfo() {
        String cardNumber = generateValidCardNumber();
        String year = generateValidYear();
        String month = generateValidMonth(year);
        String cardHolder = generateValidName();
        String CVC = generateValidCVC();
        return new AuthInfo (cardNumber, month, year, cardHolder, CVC);
    }
    public static AuthInfo getApprovedAuthInfo() {
        String cardNumber = getApprovedCardNumber();
        String year = generateValidYear();
        String month = generateValidMonth(year);
        String cardHolder = generateValidName();
        String CVC = generateValidCVC();

        return new AuthInfo (cardNumber, year, month, cardHolder, CVC);
    }

    public static AuthInfo getDeclinedAuthInfo() {
        String cardNumber = getDeclinedCardNumber();
        String year = generateValidYear();
        String month = generateValidMonth(year);
        String cardHolder = generateValidName();
        String CVC = generateValidCVC();

        return new AuthInfo (cardNumber, year, month, cardHolder, CVC);
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
