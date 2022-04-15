package lesson6_JunitParametrizedTests;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage {

    public void checkListOfTickets() {
        $$("[class*= product-list]").shouldHave(CollectionCondition.sizeGreaterThanOrEqual(5));
    }
}
