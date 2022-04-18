package lesson7_Allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

    public class AnnotatedStepTest {

        private static final String REPOSITORY = "IrinaBurtovaya/qa.guru_12";

        @BeforeAll
        public static void setUp() {
            Configuration.holdBrowserOpen = true;
            Configuration.browserSize = "1920x1080";
        }

        @Test
        public void testGithubIssue() {
            SelenideLogger.addListener("allure", new AllureSelenide());
            WebSteps steps = new WebSteps();

            steps.openMainPage();
            steps.searchForRepository(REPOSITORY);
            steps.clickOnRepositoryLink(REPOSITORY);
            steps.openIssuesTab();
            steps.shouldCheckIssueName();
        }
    }


