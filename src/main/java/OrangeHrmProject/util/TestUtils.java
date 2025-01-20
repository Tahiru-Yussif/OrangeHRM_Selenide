package OrangeHrmProject.util;

import OrangeHrmProject.pages.AdminPage.UserManagementPage;
import OrangeHrmProject.pages.UserProfilePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class TestUtils {

    private static final Logger logger = LogManager.getLogger(TestUtils.class);
    private static final UserManagementPage userManagementPage = new UserManagementPage();

    public static void logoutAfterTest(UserProfilePage userProfile) {
        logger.info("Logging out after test.");
        userProfile.clickUserProfileButton();
        userProfile.clickLogoutButton();
        logger.info("Logout successful.");
    }

//    public static void verifySuccessMessage() {
//        String successMessage = userManagementPage.getSuccessMessage(Constants.SUCCESS, Constants.SUCCESSFULLY_SAVED);
//        logger.info("Success message received: {}", successMessage);
//
//        Assert.assertTrue(
//                successMessage.contains(Constants.SUCCESS) && successMessage.contains(Constants.SUCCESSFULLY_SAVED),
//                "Success message does not contain expected texts."
//        );
//        logger.info("Success message verified.");
//    }

    public static void verifyRequiredFieldErrors() {
        String employeeNameError = userManagementPage.getEmployeeNameErrorMessage();
        Assert.assertTrue(employeeNameError.contains("Required"),
                "Expected 'Required' error message for employee name but found: " + employeeNameError);
        logger.info("Error message for missing fields verified successfully.");
    }

}
