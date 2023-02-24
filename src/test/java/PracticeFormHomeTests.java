import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormHomeTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").sendKeys("Ivanov77@example.com");
        $("#gender-radio-1").sendKeys(" ");
        $("#userNumber").sendKeys("1234567890");
        $("#dateOfBirthInput").click();
        $(by("class", "react-datepicker__year-select")).$(byText("1987")).click();
        $(by("class", "react-datepicker__month-select")).$(byText("March")).click();
        $(by("class", "react-datepicker__month-container")).$(byText("18")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-1").sendKeys(" ");
        $("#uploadPicture").uploadFile(new File("src/test/resources/photo_2023-02-24_16-16-09.jpg"));
        $("#currentAddress").sendKeys("address address");
        $("#state").scrollIntoView(true);
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").sendKeys(Keys.ENTER);

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
}