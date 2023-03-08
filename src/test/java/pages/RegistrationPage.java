package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            userGender = $("#genterWrapper"),
            userPhoneNumber = $("#userNumber"),
            pickDate = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            tickBox = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            userState = $("#state"),
            userCity = $("#city"),
            submitButton = $("#submit");
    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setUserEmail(String value) {
        userEmail.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value) {
        userGender.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setPhoneNumber(String value) {
        userPhoneNumber.setValue(value);

        return this;
    }
    public RegistrationPage setBirthDay(String day, String month, String year) {
        pickDate.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage chooseHobby(String value) {
        tickBox.$(byText(value)).click();

        return this;
    }
    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFile(new File(value));

        return this;
    }
    public RegistrationPage setAddress(String value) {
        currentAddress.sendKeys(value);

        return this;
    }
    public RegistrationPage scrollPageIntoView(Boolean value) {
        userState.scrollIntoView(value);

        return this;
    }
    public RegistrationPage selectState(String value) {
        userState.click();
        userState.$(byText(value)).click();

        return this;
    }
    public RegistrationPage selectCity(String value) {
        userCity.click();
        userCity.$(byText(value)).click();

        return this;
    }
    public RegistrationPage submit() {
        submitButton.click();

        return this;
    }

}