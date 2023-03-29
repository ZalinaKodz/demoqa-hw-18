
import com.github.javafaker.Faker;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class UserDataDetailsForForm {

    Faker faker = new Faker();
    String userFilePath = "src/test/resources/photo_2023-02-24_16-16-09.jpg";

    String[] subjects = new String[]{"Accounting", "Maths", "Arts",
            "English", "Physics", "Chemistry", "Computer Science",
            "Economics", "Social Studies", "History", "Civics", "Commerce",
            "Hindi", "Biology"};
    String[] hobbies = new String[]{"Reading", "Sports", "Music"};



    Map<String, String[]> statesAndCities = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"});



       Date dateOfBirth = faker.date().birthday();
       public String dayOfBirth = (new SimpleDateFormat("dd", Locale.ENGLISH)).format(dateOfBirth),
                monthOfBirth = (new SimpleDateFormat("MMMM", Locale.ENGLISH)).format(dateOfBirth),
                yearOfBirth = (new SimpleDateFormat("y", Locale.ENGLISH)).format(dateOfBirth);


    public String
        firstName = faker.name().firstName(),
        lastName = faker.name().lastName(),
        userEmail = faker.internet().emailAddress(),
        userGender = faker.demographic().sex(),
        userMobilePhone = 8 + faker.phoneNumber().subscriberNumber(9),
        userSubject = faker.options().option(subjects),
        userHobby = faker.options().option(hobbies),
        userAddress = faker.address().fullAddress(),
        userState = faker.options().option(statesAndCities.keySet().toArray()).toString(),
        userCity = faker.options().option(statesAndCities.get(userState));


}
