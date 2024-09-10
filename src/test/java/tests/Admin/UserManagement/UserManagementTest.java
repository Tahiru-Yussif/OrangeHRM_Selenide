package tests.Admin.UserManagement;

import OrangeHrmProject.pages.AdminPage.userManagementPage;
import OrangeHrmProject.util.LoginBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.basetest.BaseTest;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class UserManagementTest extends BaseTest {

private static final Logger logger = LogManager.getLogger(UserManagementTest.class);
private userManagementPage users;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp(); // Call the base class setup if needed
        users = new userManagementPage(); // Updated class name
    }

    @Test(priority = 1)
    public void verifyUserManagementPage() {

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

    @Test(priority = 2)
    public void createUser() {

        // Navigate to the user management page
//        users.clickAdminButton();

        users.clickAddUserButton();

        users.selectUserRole();
        sleep(5000);

    }
}
