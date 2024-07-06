package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.TestData;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement emailField = $("[data-qa='login-email']");
    private final SelenideElement passwordField = $("[data-qa='login-password']");
    private final SelenideElement submitButton = $("[data-qa='login-submit']");
    private final SelenideElement errorMessage = $("[data-qa='error-message']");

    @Step("Open login page")
    public LoginPage openLoginPage() {
        open("https://dashboard.fundraiseup.com/user/login");
        return this;
    }

    @Step("Fill in the fields with random data")
    public LoginPage fillRandomDataAndSubmitAttempt() {
        TestData testData = new TestData();
        emailField.sendKeys(testData.randomEmail);
        passwordField.sendKeys(testData.randomPassword);
        submitButton.click();
        return this;
    }

    @Step("Check error message with unsuccessful login")
    public LoginPage checkErrorMessageWithUnsuccessfulLogin() {
        errorMessage.shouldBe(visible).shouldHave(text("Incorrect email or password."));
        return this;
    }
}
