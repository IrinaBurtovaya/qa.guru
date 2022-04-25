package lesson9_Github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    SelenideElement rectangleA = $("#column-a");
    SelenideElement rectangleB = $("#column-b");

    @BeforeAll
    public static void openPage() {
        Configuration.holdBrowserOpen = true;
        String baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
        Configuration.browserSize = "1920x1080";
        open(baseUrl);
    }

    @Test
    void DragAndDropTest() {
        rectangleA.dragAndDropTo(rectangleB);
        rectangleA.shouldHave(Condition.text("B"));
        rectangleB.shouldHave(Condition.text("A"));
    }
}
