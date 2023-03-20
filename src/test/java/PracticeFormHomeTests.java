import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationFinalModal;


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
                userMobilePhone = 8 + faker.phoneNumber().subscriberNumber(9),
                userSubject = faker.options().option(UserDataDetailsForForm.subjects),
                userPicture = UserDataDetailsForForm.userFilePath,
                userHobby = faker.options().option(UserDataDetailsForForm.hobby),
                userAddress = faker.address().fullAddress(),
                userState = faker.options().option(UserDataDetailsForForm.statesAndCities.keySet().toArray()).toString(),
                userCity = faker.options().option(UserDataDetailsForForm.statesAndCities.get(userState));


        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setPhoneNumber(userMobilePhone)
                .setBirthDay(UserDataDetailsForForm.dayOfBirth, UserDataDetailsForForm.monthOfBirth, UserDataDetailsForForm.yearOfBirth)
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
                .verifyModalResult("Date of Birth", UserDataDetailsForForm.dayOfBirth + " " + UserDataDetailsForForm.monthOfBirth + "," + UserDataDetailsForForm.yearOfBirth)
                .verifyModalResult("Subjects", userSubject)
                .verifyModalResult("Hobbies", userHobby)
                .verifyModalResult("Picture", "photo_2023-02-24_16-16-09.jpg")
                .verifyModalResult("Address", userAddress)
                .verifyModalResult("State and City", userState + " " + userCity);

    }
}