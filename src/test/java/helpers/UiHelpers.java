package helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

public class UiHelpers {

    public static void clickWithAttempts(SelenideElement baseElement, SelenideElement controlElement, Condition condition) {
        int maxAttempts = 5;
        int attempts = 0;
        while (!controlElement.is(condition) && attempts < maxAttempts) {
            baseElement.scrollIntoView(true).click();
            attempts++;
            Selenide.sleep(500);
            if (controlElement.is(condition)) {
                System.out.printf("Element %s became %s after %d click attempts", controlElement, condition, attempts);
            }
        }
        if (!controlElement.is(condition)) {
            Assertions.fail(String.format("Element %s is not %s after %d click attempts", controlElement, condition, maxAttempts));
        }
    }
}
