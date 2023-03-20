import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class UserDataDetailsForForm {

    public static String[] subjects = {"Accounting", "Maths", "Arts",
            "English", "Physics", "Chemistry", "Computer Science",
            "Economics", "Social Studies", "History", "Civics", "Commerce",
            "Hindi", "Biology"};
    public static String[] hobby = {"Reading", "Sports", "Music"};
    public static Map<String, String[]> statesAndCities = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    public static String userFilePath = "src/test/resources/photo_2023-02-24_16-16-09.jpg";


    static Faker faker = new Faker();

    static Date dateOfBirth = faker.date().birthday();
    public  static String dayOfBirth = (new SimpleDateFormat("dd", Locale.ENGLISH)).format(dateOfBirth),
            monthOfBirth = (new SimpleDateFormat("MMMM", Locale.ENGLISH)).format(dateOfBirth),
            yearOfBirth = (new SimpleDateFormat("y", Locale.ENGLISH)).format(dateOfBirth);


}
