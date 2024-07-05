package helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static org.assertj.core.api.Assertions.*;

public class UiHelpers {

    public static void clickWithAttempts(SelenideElement baseElement, SelenideElement controlElement, Condition condition) {
        int maxAttempts = 5;
        int attempts = 0;
        while (!controlElement.is(condition) && attempts < maxAttempts) {
            baseElement.scrollIntoView(true).click();
            attempts++;
            Selenide.sleep(1000);
            if (controlElement.is(condition)) {
                System.out.printf("Element %s became %s after %d click attempts", controlElement, condition, attempts);
            }
        }
        if (!controlElement.is(condition)) {
            fail("Element %s is not %s after %d click attempts", controlElement, condition, maxAttempts);
        }
    }
}
