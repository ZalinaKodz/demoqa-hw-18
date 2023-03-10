import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationFinalModal;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;

public class PracticeFormHomeTests extends TestBase {
    public RegistrationPage registrationPage = new RegistrationPage();
    public RegistrationFinalModal registrationFinalModal = new RegistrationFinalModal();

    @Test
    void fillFormTest() {
        Faker faker = new Faker();

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = faker.demographic().sex(),
                userMobilePhone = 8 + faker.phoneNumber().subscriberNumber(9);

        String birthday = new SimpleDateFormat("yyyy-MMMM-dd", Locale.ENGLISH).format(faker.date().birthday());// генерируем д.р.
        String[] out = birthday.split("-");

        String dayOfBirth = out[2],
                monthOfBirth = out[1],
                yearOfBirth = out[0],
                userSubject = faker.options().option(UserDataDetailsForForm.subjects),
                userPicture = UserDataDetailsForForm.userFilePath,
                userHobby = faker.options().option(UserDataDetailsForForm.hobby),
                userAddress = faker.address().fullAddress(),
                userState = faker.options().option(UserDataDetailsForForm.state);

        String city; // для выбора города
        if (Objects.equals(userState, "NCR")) {
            city = faker.options().option(UserDataDetailsForForm.ncr);
        } else if (Objects.equals(userState, "Uttar Pradesh")) {
            city = faker.options().option(UserDataDetailsForForm.uttarpradesh);
        } else if (Objects.equals(userState, "Haryana")) {
            city = faker.options().option(UserDataDetailsForForm.haryana);
        } else {
            city = faker.options().option(UserDataDetailsForForm.rajasthan);
        }
        String userCity = city;


        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setPhoneNumber(userMobilePhone)
                .setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(userSubject)
                .chooseHobby(userHobby)
                .uploadPicture(userPicture)
                .setAddress(userAddress)
                .scrollPageIntoView(true)
                .selectState(userState)
                .selectCity(userCity)
                .submit();

        registrationFinalModal.verifyModalDetails()
                .verifyModalResult("Student Name", firstName + ' ' + lastName)
                .verifyModalResult("Student Email", userEmail)
                .verifyModalResult("Gender", userGender)
                .verifyModalResult("Mobile", userMobilePhone)
                .verifyModalResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyModalResult("Subjects", userSubject)
                .verifyModalResult("Hobbies", userHobby)
                .verifyModalResult("Picture", "photo_2023-02-24_16-16-09.jpg")
                .verifyModalResult("Address", userAddress)
                .verifyModalResult("State and City", userState + " " + userCity);

    }
}