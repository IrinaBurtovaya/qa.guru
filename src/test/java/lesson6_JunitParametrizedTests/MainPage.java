package lesson6_JunitParametrizedTests;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public void clearFields() {
        $("[data-test-id=origin-autocomplete-field]").clear();
        $("[data-test-id=destination-autocomplete-field").clear();
    }

    public MainPage setOrigin(String value) {
        $("[data-test-id=origin-autocomplete-field]").setValue(value).pressEnter();
        return this;
    }

    public MainPage setDestination(String value) {
        $("[data-test-id=destination-autocomplete-field").setValue(value).pressEnter();
        return this;
    }

    public void pressButtonSearch() {
        $("[data-test-id=\"form-submit\"]").click();
    }
}
