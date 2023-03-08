import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationFinalModal;


public class PracticeFormHomeTests extends TestBase {
    public RegistrationPage registrationPage = new RegistrationPage();
    public RegistrationFinalModal registrationFinalModal = new RegistrationFinalModal();
    @Test
    void fillFormTest() {
        String firstname = "Ivan",
                lastname = "Ivanov",
                email = "Ivanov77@example.com",
                gender = "Male",
                phone = "1234567890",
                day = "18",
                month = "March",
                year = "1987",
                subject = "Maths",
                picture = "src/test/resources/photo_2023-02-24_16-16-09.jpg",
                hobby = "Reading",
                address = "address address",
                state = "NCR",
                city = "Delhi";

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setUserEmail(email)
                .setGender(gender)
                .setPhoneNumber(phone)
                .setBirthDay(day, month, year)
                .setSubject(subject)
                .chooseHobby(hobby)
                .uploadPicture(picture)
                .setAddress(address)
                .scrollPageIntoView(true)
                .selectState(state)
                .selectCity(city)
                .submit();

        registrationFinalModal.verifyModalDetails()
                .verifyModalResult("Student Name", firstname + ' ' + lastname)
                .verifyModalResult("Student Email", email)
                .verifyModalResult("Gender", gender)
                .verifyModalResult("Mobile", phone)
                .verifyModalResult("Date of Birth", day + " " + month + "," + year)
                .verifyModalResult("Subjects", subject)
                .verifyModalResult("Hobbies", hobby)
                .verifyModalResult("Picture", "photo_2023-02-24_16-16-09.jpg")
                .verifyModalResult("Address", address)
                .verifyModalResult("State and City", state + " " + city);

    }
}