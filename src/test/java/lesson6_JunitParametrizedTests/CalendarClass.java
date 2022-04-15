package lesson6_JunitParametrizedTests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CalendarClass {
    SelenideElement calendarCaptionDepartureDate = $x("(//select[@class='calendar-caption__select'])[1]");
    SelenideElement calendarCaptionReturnDate = $x("(//select[@class='calendar-caption__select'])[2]");
    ElementsCollection list = $$("[class*=day-cell]");

    public CalendarClass setDepartureDate(int month, int date) {
        $("[data-test-id=departure-date-field]").click();
        calendarCaptionDepartureDate.click();
        calendarCaptionDepartureDate.selectOption(month);
        calendarCaptionDepartureDate.click();
        list.asDynamicIterable();
        list.get(date).click();
        return this;
    }

    public CalendarClass setReturnDate(int month, int date) {
        $("[data-test-id=return-date-field]").click();
        calendarCaptionReturnDate.click();
        calendarCaptionReturnDate.selectOption(month);
        calendarCaptionReturnDate.click();
        list.asDynamicIterable();
        list.get(date).pressEnter();
        return this;
    }
}