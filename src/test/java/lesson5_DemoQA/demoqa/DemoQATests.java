package lesson5_DemoQA.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DemoQATests {

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
