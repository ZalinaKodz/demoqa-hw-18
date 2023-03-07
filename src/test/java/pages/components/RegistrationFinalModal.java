package pages.components;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFinalModal {
    public void verificationDetails() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
    public void verificationResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }


}
