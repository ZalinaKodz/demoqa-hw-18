
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationFinalModal;


public class PracticeFormHomeTests extends TestBase {
    public RegistrationPage registrationPage = new RegistrationPage();
    public RegistrationFinalModal registrationFinalModal = new RegistrationFinalModal();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(UserDataDetailsForForm.firstName)
                .setLastName(UserDataDetailsForForm.lastName)
                .setUserEmail(UserDataDetailsForForm.userEmail)
                .setGender(UserDataDetailsForForm.userGender)
                .setPhoneNumber(UserDataDetailsForForm.userMobilePhone)
                .setBirthDay(UserDataDetailsForForm.dayOfBirth, UserDataDetailsForForm.monthOfBirth, UserDataDetailsForForm.yearOfBirth)
                .setSubject(UserDataDetailsForForm.userSubject)
                .chooseHobby(UserDataDetailsForForm.userHobby)
                .uploadPicture(UserDataDetailsForForm.userPicture)
                .setAddress(UserDataDetailsForForm.userAddress)
                .scrollPageIntoView(true)
                .selectState(UserDataDetailsForForm.userState)
                .selectCity(UserDataDetailsForForm.userCity)
                .submit();

        registrationFinalModal.verifyModalDetails()
                .verifyModalResult("Student Name", UserDataDetailsForForm.firstName + ' ' + UserDataDetailsForForm.lastName)
                .verifyModalResult("Student Email", UserDataDetailsForForm.userEmail)
                .verifyModalResult("Gender", UserDataDetailsForForm.userGender)
                .verifyModalResult("Mobile", UserDataDetailsForForm.userMobilePhone)
                .verifyModalResult("Date of Birth", UserDataDetailsForForm.dayOfBirth + " " + UserDataDetailsForForm.monthOfBirth + "," + UserDataDetailsForForm.yearOfBirth)
                .verifyModalResult("Subjects", UserDataDetailsForForm.userSubject)
                .verifyModalResult("Hobbies", UserDataDetailsForForm.userHobby)
                .verifyModalResult("Picture", "photo_2023-02-24_16-16-09.jpg")
                .verifyModalResult("Address", UserDataDetailsForForm.userAddress)
                .verifyModalResult("State and City", UserDataDetailsForForm.userState + " " + UserDataDetailsForForm.userCity);

    }
}