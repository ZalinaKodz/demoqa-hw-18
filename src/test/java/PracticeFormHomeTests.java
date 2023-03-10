import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationFinalModal;

import static utils.RandomUtils.getRandomItemFromArray;


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
                dayOfBirth = String.valueOf(faker.number().numberBetween(1,28)),
                monthOfBirth = getRandomItemFromArray(TestData.months),
                yearOfBirth = String.valueOf(faker.number().numberBetween(1920,2010)),
                userSubject = getRandomItemFromArray(TestData.subjects),
                userPicture = TestData.userFilePath,
                userHobby = faker.options().option(TestData.hobby),
                userAddress = faker.address().fullAddress(),
                userState = "NCR",
                userCity = getRandomItemFromArray(TestData.cities);

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
                .verifyModalResult("Picture", TestData.userFileName)
                .verifyModalResult("Address", userAddress)
                .verifyModalResult("State and City", userState + " " + userCity);

    }
}