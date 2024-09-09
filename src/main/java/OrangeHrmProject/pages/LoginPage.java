package OrangeHrmProject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.confirm;

public class LoginPage {
    private final SelenideElement usernameField = $(By.cssSelector("input[name='username']"));
    private final SelenideElement passwordField = $(By.cssSelector("input[type='password']"));
    private final SelenideElement loginButton = $(By.cssSelector("button[type='submit']"));
    private final SelenideElement errorMessage = $(By.cssSelector("div.orangehrm-login-error p"));

//    // Method to enter email
    public void enterUsername(String username) {
       usernameField.setValue(username);
       usernameField.shouldHave(Condition.value(username));
    }
//
//    // Method to enter password
    public void enterPassword(String password) {
        passwordField.setValue(password);
        passwordField.shouldHave(Condition.value(password));
    }
    // Method to click the login button
    public void clickLoginButton() {
        loginButton.shouldBe(Condition.enabled).click();
    }

    // Perform login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
