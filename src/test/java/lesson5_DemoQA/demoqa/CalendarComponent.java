package lesson5_DemoQA.demoqa;

import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {

    public void setDate(int monthIndex, String yearIndex, String day) {
        $x("//select[@class='react-datepicker__month-select']").selectOption(monthIndex);
        $x("//select[@class='react-datepicker__year-select']").selectOptionByValue(yearIndex);
        $x("//div[@class='react-datepicker__day react-datepicker__day--0" + day +
                " react-datepicker__day--weekend']").click();
    }
}
