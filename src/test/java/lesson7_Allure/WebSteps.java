package lesson7_Allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $("[data-test-selector=nav-search-input]").
                click();
        $("[data-test-selector=nav-search-input]").
                setValue(repo);
        $("[data-test-selector=nav-search-input]").
                submit();
    }

    @Step("Переход по ссылке {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Кликаем на таб Issues")
    public void openIssuesTab() {
        $("#issues-repo-tab-count").click();
    }

    @Step("Проверяем issue по названию")
    public void shouldCheckIssueName() {
        $("#issue_8_link").shouldHave(Condition.text("New issue #1"));
    }
}
