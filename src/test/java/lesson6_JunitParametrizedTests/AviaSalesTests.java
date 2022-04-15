package lesson6_JunitParametrizedTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class AviaSalesTests {
    MainPage mainPage = new MainPage();
    CalendarClass calendar = new CalendarClass();
    SearchPage searchPage = new SearchPage();

    @BeforeEach
    public void openPage() {
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 30000;
        baseUrl = "https://www.aviasales.ru/";
        Configuration.browserSize = "1920x1080";
        open(baseUrl);
        mainPage.clearFields();
    }

    @Disabled
    @DisplayName("Тест на проверку наличия билетов по маршруту Москва - Сочи")
    @Test
    void searchTickets() {
        mainPage.setOrigin("Москва")
                .setDestination("Сочи");
        calendar.setDepartureDate(5, 4)
                .setReturnDate(5, 10);
        mainPage.pressButtonSearch();
        Selenide.switchTo().window(1);
        searchPage.checkListOfTickets();
    }

    @ValueSource(strings = {
            "Минск",
            "Екатеринбург"
    })
    @ParameterizedTest(name = "Тест на проверку наличия билетов по маршруту {0}")
    void searchTicketsValueSource(String testOrigin) {
        mainPage.setOrigin(testOrigin)
                .setDestination("Сочи");
        calendar.setDepartureDate(5, 4)
                .setReturnDate(5, 10);
        mainPage.pressButtonSearch();
        Selenide.switchTo().window(1);
        searchPage.checkListOfTickets();
    }

    @CsvSource(value = {
            "Санкт-Петербург | Москва",
            "Москва | Сочи"
    },
            delimiter = '|')
    @ParameterizedTest(name = "Тест на проверку наличия билетов по маршруту {0}" + " - " + "{1}")
    void searchTicketsCsvSource(String testOrigin, String testDestination) {
        mainPage.setOrigin(testOrigin)
                .setDestination(testDestination);
        calendar.setDepartureDate(5, 4)
                .setReturnDate(5, 10);
        mainPage.pressButtonSearch();
        Selenide.switchTo().window(1);
        searchPage.checkListOfTickets();
    }

    static Stream<Arguments> checkDiffRoutes() {
        return Stream.of(
                Arguments.of("Москва", "Анапа"),
                Arguments.of("Пермь", "Санкт-Петербург")
        );
    }

    @MethodSource("checkDiffRoutes")
    @ParameterizedTest
    void searchTicketsMethodSource(String testOrigin, String testDestination) {
        mainPage.setOrigin(testOrigin)
                .setDestination(testDestination);
        calendar.setDepartureDate(5, 4)
                .setReturnDate(5, 10);
        mainPage.pressButtonSearch();
        Selenide.switchTo().window(1);
        searchPage.checkListOfTickets();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();

    }
}
