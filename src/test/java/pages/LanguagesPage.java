package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LanguagesPage {

    private final SelenideElement pageHeader = $(".h2");
    private final SelenideElement languagesHeader = $("h3.text-center");
    private final ElementsCollection languagesIcons = $$(".label-1.d-flex");

    @Step("Open languages page")
    public LanguagesPage openLanguagesPage() {
        open("/features/languages/");
        pageHeader.shouldBe(visible);
        return this;
    }

    @Step("Check number of language icons")
    public LanguagesPage checkNumberOfLanguageIcons() {
        languagesHeader.shouldBe(visible);
        Assertions.assertThat(languagesHeader.getText().split(" ")[0])
                .withFailMessage("Number of languages in header '%s' is not equal to number of language icons '%s'",
                        languagesHeader.getText().split(" ")[0], languagesIcons.size())
                .isEqualTo(String.valueOf(languagesIcons.size()));
        return this;
    }
}
