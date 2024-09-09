package tests.LoginFunctionality;

import OrangeHrmProject.pages.LoginPage;
import OrangeHrmProject.util.LoginBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import tests.basetest.BaseTest;

public class LoginUnsuccessfulTest extends BaseTest {

    // logs
    private static final Logger logger = LogManager.getLogger(LoginUnsuccessfulTest.class);

    @Test
    public void loginUnsuccessful() {
        logger.info("Starting the unsuccessful login test");

        LoginPage loginPage = new LoginPage();

        logger.info("Navigating to the login page and attempting login with invalid credentials");
        LoginBase.logIn(baseURL, invalidUsername, invalidPassword);

        // Get error message
        logger.info("Attempting to retrieve the error message from the login page");
        String errorMessage = loginPage.getErrorMessage();

        // Log the error message
        logger.info("Error message displayed: " + errorMessage);

        // Assert that the error message is displayed
        if (errorMessage.contains("Invalid credentials")) {
            logger.info("Assertion passed: Error message contains 'Invalid credentials'");
        } else {
            logger.error("Assertion failed: Error message does not match the expected text");
        }

        assert errorMessage.contains("Invalid credentials") : "Error message does not match expected";

        logger.info("Unsuccessful login test completed");
    }
}
