package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class AuhtInfo {
        String login;
        String password;
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    private static final Faker faker = new Faker(new Locale("en"));

    public static AuhtInfo getAuhtInfo() {
        return new AuhtInfo("vasya", "qwerty123");
    }

    private static String generateRandomLogin() {
        return faker.name().username();
    }

    private static String generateRandomPassword() {
        return faker.internet().password();
    }

    public static AuhtInfo generateRandomUser() {
        return new AuhtInfo(generateRandomLogin(), generateRandomPassword());
    }

    public static VerificationCode generateRandomVerificationCode() {
        return new VerificationCode(faker.numerify("######"));
    }
}
