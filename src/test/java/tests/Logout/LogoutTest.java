package tests.Logout;

import OrangeHrmProject.pages.UserProfilePage;
import OrangeHrmProject.util.LoginBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.basetest.BaseTest;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

/**
 * This test class handles the user logout functionality in the application.
 * It extends the BaseTest class to inherit the basic test setup and teardown processes.
 */
public class LogoutTest extends BaseTest {

    // Logger for logging test steps and results
    private static final Logger logger = LogManager.getLogger(LogoutTest.class);

    // Instance of UserProfilePage to handle actions related to the user profile dropdown and logout
    private UserProfilePage userProfile;

    /**
     * The setUp() method is executed before each test to initialize the required components
     * and log in the user to perform subsequent actions.
     */
    @BeforeMethod
    @Override
    public void setUp() {
        // Call the BaseTest class's setUp() to initialize common configurations
        super.setUp();

        // Log in before each test execution
        logger.info("Logging in before the test");
        LoginBase.logIn(baseURL, validUsername, validPassword);
        logger.info("Login completed before the test");
    }

    /**
     * This test handles the logout process by navigating to the user profile menu and clicking on the logout button.
     * It verifies whether the user is successfully logged out by checking the redirected URL.
     */
    @Test(priority = 1)
    public void logout() {
        // Log the attempt to logout
        logger.info("Attempting to log out...");

        userProfile = new UserProfilePage();
        logger.info("Setup complete, UserProfilePage initialized.");
        // Click on the user profile button to open the profile dropdown
        userProfile.clickUserProfileButton();

        // Click the Logout button to initiate the logout process
        userProfile.clickLogoutButton();

        // Fetch the current URL after clicking logout
        String currentUrl = url();

        // Log the expected and actual URLs for debugging purposes
        logger.info("Expected dashboard URL: {}", baseURL); // The expected base URL after logout
        logger.info("Actual URL after login: {}", currentUrl); // The actual URL fetched after logout

        // Verify that the current URL matches the base URL (i.e., user is logged out and redirected)
        try {
            assertEquals(currentUrl, baseURL, "URLs do not match"); // Assertion to confirm logout success

            // Check if the OrangeHRM logo is displayed, confirming the user is back on the login screen
            userProfile.isDisplayedOrangeHRMLogo();

            logger.info("Logout test passed: URLs match");
        } catch (AssertionError e) {
            // If the assertion fails, log the error and rethrow it to fail the test
            logger.error("Logout test failed: {}", e.getMessage());
            throw e;
        }

        // Log successful completion of the logout process
        logger.info("User logged out successfully");
    }
}
