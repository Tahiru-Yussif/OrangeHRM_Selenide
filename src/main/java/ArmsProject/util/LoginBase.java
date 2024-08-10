package ArmsProject.util;

import ArmsProject.pages.LoginPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class LoginBase {

    public static void logIn(String baseURL, String username, String password) {
        // Open the login page
        open(baseURL + "/login");

        // Instantiate the LoginPage object
        LoginPage signInPage = new LoginPage();

        // Perform sign-in
        signInPage.clickSignInButton();
        signInPage.enterEmail(username);
        signInPage.clickNextButton();
        signInPage.enterPassword(password);
        signInPage.clickNextButton();

        // Enter the TOTP code
        int totpCode = AppConfig.TOTPExample();
        $(By.name("otc")).val(String.valueOf(totpCode));
        signInPage.clickVerifyButton();

        // Wait for the page to load and the expected URL to be present
//        sleep(1000);

        signInPage.clickSkipButton();
//        sleep(1000);
        signInPage.clickSkipButton2();

        // Get the current URL & expected URL
        String currentUrl = url();

        // Assert that the current URL matches the expected URL
        assertEquals(currentUrl, baseURL, "URLs do not match");
    }
}
