
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationFinalModal;

import static io.qameta.allure.Allure.step;

@Tag("demoqa")
public class PracticeFormHomeTests extends TestBase {
 RegistrationPage registrationPage = new RegistrationPage();
 RegistrationFinalModal registrationFinalModal = new RegistrationFinalModal();
UserDataDetailsForForm userDataDetailsForForm = new UserDataDetailsForForm();

    @Test
    void fillFormTest() {
        step("Fill form", () -> {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(userDataDetailsForForm.firstName)
                .setLastName(userDataDetailsForForm.lastName)
                .setUserEmail(userDataDetailsForForm.userEmail)
                .setGender(userDataDetailsForForm.userGender)
                .setPhoneNumber(userDataDetailsForForm.userMobilePhone)
                .setBirthDay(userDataDetailsForForm.dayOfBirth, userDataDetailsForForm.monthOfBirth, userDataDetailsForForm.yearOfBirth)
                .setSubject(userDataDetailsForForm.userSubject)
                .chooseHobby(userDataDetailsForForm.userHobby)
                .uploadPicture(userDataDetailsForForm.userFilePath)
                .setAddress(userDataDetailsForForm.userAddress)
                .scrollPageIntoView(true)
                .selectState(userDataDetailsForForm.userState)
                .selectCity(userDataDetailsForForm.userCity)
                .submit();
        });

        step("Verify results", () -> {
        registrationFinalModal.verifyModalDetails()
                .verifyModalResult("Student Name", userDataDetailsForForm.firstName + ' ' + userDataDetailsForForm.lastName)
                .verifyModalResult("Student Email", userDataDetailsForForm.userEmail)
                .verifyModalResult("Gender", userDataDetailsForForm.userGender)
                .verifyModalResult("Mobile", userDataDetailsForForm.userMobilePhone)
                .verifyModalResult("Date of Birth", userDataDetailsForForm.dayOfBirth + " " + userDataDetailsForForm.monthOfBirth + "," + userDataDetailsForForm.yearOfBirth)
                .verifyModalResult("Subjects", userDataDetailsForForm.userSubject)
                .verifyModalResult("Hobbies", userDataDetailsForForm.userHobby)
                .verifyModalResult("Picture", "photo_2023-02-24_16-16-09.jpg")
                .verifyModalResult("Address", userDataDetailsForForm.userAddress)
                .verifyModalResult("State and City", userDataDetailsForForm.userState + " " + userDataDetailsForForm.userCity);
        });
    }
}