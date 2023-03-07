import org.junit.jupiter.api.Test;


public class PracticeFormHomeTests extends TestBase {

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setUserEmail("Ivanov77@example.com")
                .setGender("Male")
                .setPhoneNumber("1234567890")
                .setBirthDay("18", "March", "1987")
                .setSubject("Maths")
                .chooseHobby("Reading")
                .uploadPicture("src/test/resources/photo_2023-02-24_16-16-09.jpg")
                .setAddress("address address")
                .scrollPage(true)
                .selectState("NCR")
                .selectCity("Delhi")
                .submit();


        registrationPage.verificationModal()
                .verificationResult("Student Name", "Ivan Ivanov")
                .verificationResult("Student Email", "Ivanov77@example.com")
                .verificationResult("Gender", "Male")
                .verificationResult("Mobile", "1234567890")
                .verificationResult("Date of Birth", "18 March,1987")
                .verificationResult("Subjects", "Maths")
                .verificationResult("Hobbies", "Reading")
                .verificationResult("Picture", "photo_2023-02-24_16-16-09.jpg")
                .verificationResult("Address", "address address")
                .verificationResult("State and City", "NCR Delhi")
                .closeModal();

    }
}