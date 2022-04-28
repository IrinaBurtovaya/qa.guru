package lesson10_jenkins;

import com.github.javafaker.Faker;
import lesson5_DemoQA.demoqa.CalendarComponent;
import lesson5_DemoQA.demoqa.RegistrationFormPage;
import org.junit.jupiter.api.Assertions;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationFormPageDuplicatedForL10 extends RegistrationFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String studentGender = "Male";
    String phoneNumber = "8555555555";
    String date = "05 August,1990";
    String subject = "Maths";
    String hobby = "Music";
    File file = new File("src/test/resources/wolf.jpg");
    String pictureName = "wolf.jpg";
    String address = "myPlace";
    String state = "Haryana";
    String city = "Karnal";

    public RegistrationFormPage setFirstName() {
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationFormPage setLastName() {
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationFormPage setEmail() {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $x("//label[@for='gender-radio-1']").click();
        return this;
    }

    public RegistrationFormPage setPhoneNumber() {
        $("#userNumber").setValue(phoneNumber);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(int monthIndex, String yearIndex, String day) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(monthIndex, yearIndex, day);

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        $x("//label[@for='hobbies-checkbox-3']").click();
        return this;
    }

    public RegistrationFormPage uploadFile() {
        $("#uploadPicture").uploadFile(file);
        return this;
    }

    public RegistrationFormPage setStateAndCity() {
        $("#currentAddress").setValue(address);
        $("#state").scrollIntoView(true).click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").submit();
        return this;
    }

    public RegistrationFormPage checkResults() {
        String studentName = $x(".//tr[1]//td[2]").innerText();
        Assertions.assertEquals(studentName, firstName + " " + lastName);

        String studentEmail = $x(".//tr[2]//td[2]").innerText();
        Assertions.assertEquals(studentEmail, email);

        String gender = $x(".//tr[3]//td[2]").innerText();
        Assertions.assertEquals(gender, studentGender);

        String mobile = $x(".//tr[4]//td[2]").innerText();
        Assertions.assertEquals(mobile, phoneNumber);

        String dateOfBirth = $x(".//tr[5]//td[2]").innerText();
        Assertions.assertEquals(dateOfBirth, date);

        String studentSubject = $x(".//tr[6]//td[2]").innerText();
        Assertions.assertEquals(studentSubject, subject);

        String hobbies = $x(".//tr[7]//td[2]").innerText();
        Assertions.assertEquals(hobbies, hobby);

        String picture = $x(".//tr[8]//td[2]").innerText();
        Assertions.assertEquals(picture, pictureName);

        String studentAddress = $x(".//tr[9]//td[2]").innerText();
        Assertions.assertEquals(studentAddress, address);

        String stateAndCity = $x(".//tr[10]//td[2]").innerText();
        Assertions.assertEquals(stateAndCity, state + " " + city);
        return new RegistrationFormPage();
    }

}
