package ArmsProject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class LoginPage {
    private final SelenideElement signInButton = $(By.cssSelector("div.cursor-pointer"));
    private final SelenideElement emailInput = $(By.cssSelector("input[type='email']"));
    private final SelenideElement passwordInput = $(By.cssSelector("input[type='password']"));
    private final SelenideElement nextButton = $(By.cssSelector("input[type='submit']"));
    private final SelenideElement verifyButton = $(By.cssSelector("input[type='submit']"));
    private final SelenideElement skipButton = $(By.xpath("(//button[text()=' Skip '])[2]"));
    private final SelenideElement skipButton2 = $(By.xpath("(//button[text()=' Skip '])[1]"));


    // Method to perform a sign-in
    public void clickSignInButton() {
        signInButton.click();
    }

//    // Method to enter email
    public void enterEmail(String email) {
       emailInput.setValue(email);
    }
//
//    // Method to enter password
    public void enterPassword(String password) {
        passwordInput.setValue(password);
    }
//
//    // Method to click the next button
    public void clickNextButton() {
        nextButton.click();
    }

    //    // Method to click the next button
    public void clickVerifyButton() {
        verifyButton.click();
    }
//
//    // Method to click the skip button
    public void clickSkipButton() {
        skipButton.shouldBe(Condition.enabled).click();
    }

    public void clickSkipButton2() {
        skipButton2.shouldBe(Condition.enabled).click();
    }
//
//    public void clickFinalSkipButton() {
//        WebElement skipInformationButton = driver.findElement(By.xpath("(//button)[2]"));
//        skipInformationButton.click();
//    }
//
//    public void enterCode() {
//        WebElement codeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("otc")));
//        codeInput.sendKeys();
//    }
}
