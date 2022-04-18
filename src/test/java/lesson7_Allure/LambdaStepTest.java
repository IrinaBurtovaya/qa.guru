package lesson7_Allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {

    private static final String REPOSITORY = "IrinaBurtovaya/qa.guru_12";

    @BeforeAll
    public static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    public void testGithubIssue() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий  " + REPOSITORY, () -> {
            $("[data-test-selector=nav-search-input]").
                    click();
            $("[data-test-selector=nav-search-input]").
                    setValue(REPOSITORY);
            $("[data-test-selector=nav-search-input]").
                    submit();
        });
        step("Переход по ссылке", () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Кликаем на таб Issues", () -> {
            $("#issues-repo-tab-count").click();
        });
        step("Проверяем issue по названию", () -> {
            $("#issue_8_link").shouldHave(Condition.text("New issue #1"));
        });
    }
}
