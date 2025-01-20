package tests.Admin.UserManagement;

import OrangeHrmProject.pages.AdminPage.UserManagementPage;
import OrangeHrmProject.pages.UserProfilePage;
import OrangeHrmProject.util.Constants;
import OrangeHrmProject.util.LoginBase;
import OrangeHrmProject.util.TestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.basetest.BaseTest;

/**
 * This test class handles tests related to User Management within the Admin section of the application.
 *
 * It includes the following tests:
 * - Creating a user
 * - Verifying error messages when required fields are left blank
 *
 * The class follows a modular structure where common actions like login and logout
 * are abstracted into separate methods.
 */
public class UserManagementTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(UserManagementTest.class);
    private UserManagementPage userManagementPage;
    private UserProfilePage userProfile;

    /**
     * This method is executed before each test. It handles setup, such as:
     * - Initializing the required page objects (e.g., UserManagementPage)
     * - Logging in using credentials
     * - Navigating to the User Management section to prepare for the test.
     */
    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp(); // Calls the parent class setup method
        // Initialize the UserManagementPage instance
        userManagementPage = new UserManagementPage();
        logger.info("UserManagementPage initialized.");
        // Perform login action using the LoginBase utility
        logger.info("Logging in before the test");
        LoginBase.logIn(baseURL, validUsername, validPassword);
        logger.info("Login completed before the test");
        // Navigate to the User Management page
        logger.info("Navigating to User Management page.");
        userManagementPage.clickAdminButton();  // Click the Admin button
        userManagementPage.clickAddUserButton();  // Click the Add User button
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

    /**
     * This test case handles the creation of a new user.
     */
    @Test(priority = 1)
    public void createUser() {
        logger.info("Starting test: createUser");
        // Fill in user details
        logger.info("Filling in user details.");
        userManagementPage.selectUserRole();  // Select role for the user
        userManagementPage.enterEmployeeName(Constants.EMPLOYEE_NAME);  // Enter employee name
        userManagementPage.enterUserPassword(validPassword);  // Enter password
        userManagementPage.confirmUserPassword(validPassword);  // Confirm password
        userManagementPage.enterUserName(validUsername);  // Enter username
        userManagementPage.selectStatus();  // Select user status
        // Submit user creation form
        logger.info("Submitting user creation form.");
        userManagementPage.clickSubmitButton();
        // Verify success message after form submission
        String successMessage = userManagementPage.getSuccessMessage(Constants.SUCCESS, Constants.SUCCESSFULLY_SAVED);
        Assert.assertTrue(successMessage.contains(Constants.SUCCESS), "Expected 'Success' message not found");
        logger.info("User creation test completed.");
    }

    /**
     * This test case verifies if the appropriate error messages are displayed when
     * required fields are left blank during user creation.
     */
    @Test(priority = 2)
    public void verifyErrorMessageForMissingFields() {
        logger.info("Starting test: verifyErrorMessageForMissingFields");
        // Leave required fields blank
        logger.info("Leaving required fields blank and attempting to save.");
        userManagementPage.enterEmployeeName(" ");  // Blank employee name
        userManagementPage.enterUserPassword("");   // Blank password
        // Submit the form
        userManagementPage.clickSubmitButton();
        // Verify error messages for required fields
        String employeeNameError = userManagementPage.getEmployeeNameErrorMessage();
        Assert.assertTrue(employeeNameError.contains("Required"),
                "Expected 'Required' error message for employee name but found: " + employeeNameError);
        logger.info("Error message for missing fields verified successfully.");
    }
}
