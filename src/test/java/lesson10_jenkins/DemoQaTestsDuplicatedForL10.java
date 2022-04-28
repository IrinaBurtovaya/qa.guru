package lesson10_jenkins;

import com.codeborne.selenide.Configuration;
import lesson5_DemoQA.demoqa.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DemoQaTestsDuplicatedForL10 {
    @BeforeAll
    public static void openPage() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        open("automation-practice-form");
    }

    @Test
    void checkFormFilled() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(); //не нужно создавать метод main,
        // т.к. аннотация @Test позволяет создавать объекты другого класса внутри себя.

        registrationFormPage.setFirstName()
                .setLastName()
                .setEmail()
                .setGender("Male")
                .setPhoneNumber()
                .setDateOfBirth(7, "1990", "05")
                .setSubject("Maths")
                .setHobbies("Music")
                .uploadFile()
                .setStateAndCity()
                .checkResults();
    }
}
