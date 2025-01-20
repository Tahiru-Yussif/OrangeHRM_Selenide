package tests.Login;

import OrangeHrmProject.pages.AdminPage.UserManagementPage;
import OrangeHrmProject.pages.UserProfilePage;
import OrangeHrmProject.util.LoginBase;
import OrangeHrmProject.util.TestUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.basetest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class LoginSuccessTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginSuccessTest.class);
    private UserProfilePage userProfile;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp(); // Calls the parent class setup method
        // Initialize the UserProfilePage instance
        userProfile = new UserProfilePage();
    }

    /**
     * This method is executed after each test. It ensures that the user logs out
     * after the test execution to maintain a clean state for subsequent tests.
     */
    @AfterMethod
    public void tearDown() {
        TestUtils.logoutAfterTest(userProfile);  // Uses utility to handle logout
    }


    @Test
    public void loginSuccessfully() {
        logger.info("Starting the login test");

        // Attempt to log in
        logger.info("Attempting to log in with username: {}", validUsername);
        LoginBase.logIn(baseURL, validUsername, validPassword);
        logger.info("Login attempt completed");

        // Get the current URL & expected URL
        String currentUrl = url();

        // Log the URLs
        logger.info("Expected dashboard URL: {}", dashboardURL);
        logger.info("Actual URL after login: {}", currentUrl);

        // Assert that the current URL matches the expected URL
        try {
            assertEquals(currentUrl, dashboardURL, "URLs do not match");
            logger.info("Login test passed: URLs match");
        } catch (AssertionError e) {
            logger.error("Login test failed: {}", e.getMessage());
            throw e; // Rethrow the exception to fail the test
        }

        logger.info("Login test completed successfully");
    }
}
