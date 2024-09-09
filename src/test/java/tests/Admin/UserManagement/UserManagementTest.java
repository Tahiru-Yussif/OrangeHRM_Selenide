package tests.Admin.UserManagement;

import OrangeHrmProject.pages.AdminPage.userManagementPage;
import OrangeHrmProject.util.LoginBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import tests.basetest.BaseTest;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class UserManagementTest extends BaseTest {

private static final Logger logger = LogManager.getLogger(UserManagementTest.class);

    @Test
    public void createUser() {
        userManagementPage users = new userManagementPage();

        // Attempt to log in
        logger.info("Attempting to log in with username: {}", validUsername);
        LoginBase.logIn(baseURL, validUsername, validPassword);
        logger.info("Login attempt completed");

        // Navigate to the user management page
        users.clickAdminButton();

        // Get the current URL & expected URL
        String currentUrl = url();

        // Assert that the current URL matches the expected URL
        try {
            assertEquals(currentUrl, userManagementPageUrl, "URLs do not match");
            logger.info("Successfully visited the User Management page: URLs match");
        } catch (AssertionError e) {
            logger.error("Failed to visit the user management page: {}", e.getMessage());
            throw e; // Rethrow the exception to fail the test
        }
    }
}
