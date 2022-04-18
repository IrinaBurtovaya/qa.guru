package lesson7_Allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    @BeforeAll
    public static void openPage() {

        Configuration.holdBrowserOpen = true;
        String baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        open(baseUrl);
    }

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        $("[data-test-selector=\"nav-search-input\"]").
                click();
        $("[data-test-selector=\"nav-search-input\"]").
                setValue("IrinaBurtovaya/qa.guru_12");
        $("[data-test-selector=\"nav-search-input\"]").
                submit();
        $x("//a[@href=\"/IrinaBurtovaya/qa.guru_12\"]").click();
        $("#issues-repo-tab-count").click();
        $("#issue_8_link").shouldHave(Condition.text("New issue #1"));
    }
}
