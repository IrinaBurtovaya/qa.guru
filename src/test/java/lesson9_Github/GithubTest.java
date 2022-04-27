package lesson9_Github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class GithubTest {

    /*
    1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
Если может - приведите пример, когда.
Ответ: есть разница. Селектор $("h1 div") ищет сочетание указанных элементов в любом месте.
Пример:
<h1> <a> Просто текст1 </a> </h1>
<h1> <div> Просто текст2 </div> </h1>
Здесь селектор $("h1 div") - отработает.
$("h1").$("div") - ищет все элементы h1, а затем берет первый h1 и ищет в нем div. В указанном примере выше -
селектор не отработает.
Результат будет успешный для обоих случаев только тогда, когда в первом h1 будет div.
     */

    @BeforeAll
    public static void openPage() {
        Configuration.holdBrowserOpen = true;
        String baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        open(baseUrl);
    }

    @Test
    void checkJunit5CodeExists() {
        $("[type=text]").setValue("Selenide").pressEnter();
        $x("(//a[@href=\"/search?q=Selenide&type=wikis\"])[1]").click();
        $x("//a[@title=\"SoftAssertions\"]").shouldBe(Condition.visible).click();
        //$x("//div[@class=\"markdown-body\"]/*[4]/*[last()]").shouldHave(Condition.text("JUnit5"));
        $x("//*[contains(text(), 'JUnit5 extend')]").shouldHave(Condition.text("JUnit5"));

    }
}
