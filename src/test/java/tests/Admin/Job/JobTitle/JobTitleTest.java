package tests.Admin.Job.JobTitle;

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

import java.io.File;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.hamcrest.MatcherAssert.assertThat;

public class JobTitleTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(JobTitleTest.class);
    private OrangeHrmProject.pages.JobPage.JobTitlePage jobTitlePage;
    private UserProfilePage userProfile;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp(); // Calls the parent class setup method
        // Initialize required page objects
        jobTitlePage = new OrangeHrmProject.pages.JobPage.JobTitlePage();
        userProfile = new UserProfilePage();
        logger.info("JobTitlePage initialized.");
        // Perform login action using the LoginBase utility
        LoginBase.logIn(baseURL, validUsername, validPassword);
        logger.info("Login completed before the test");
        // Navigate to the User Management page
        logger.info("Navigating to JobTitle page.");
        jobTitlePage.clickAdminButtonAndNavigateToJobPage();  // Click the Admin button
    }

    @AfterMethod
    public void tearDown() {
        TestUtils.logoutAfterTest(userProfile);  // Uses utility to handle logout
    }

//    @Test(priority = 1)
    public void shouldCreateJobTitleWithValidData() {
        // Retrieve test data
        String jobTitleName = jsonData.get("jobInformation").get("jobTitle").asText();
        String jobTitleDescription = jsonData.get("jobInformation").get("jobDescription").asText();
        String jobTitleNote = jsonData.get("jobInformation").get("note").asText();
        String filePath = new File("src/test/resources/upload/certificate.pdf").getAbsolutePath();

        logger.info("Creating a new job title");
        // Fill in job title details
        jobTitlePage.clickAddJobTitleButton();
        jobTitlePage.enterJobTitle(jobTitleName + System.currentTimeMillis());
        jobTitlePage.enterJobDescription(jobTitleDescription);
        jobTitlePage.uploadJobTitleFile(filePath);
//        assertThat(filePath);
        jobTitlePage.enterJobNote(jobTitleNote);
        jobTitlePage.clickSaveButton();
        // Verify success message after form submission
        logger.info("Verifying success message.");
        // Verify success message after form submission
        String successMessage = jobTitlePage.getSuccessMessage(Constants.SUCCESS, Constants.SUCCESSFULLY_SAVED);
        Assert.assertTrue(successMessage.contains(Constants.SUCCESS), "Expected 'Success' message not found");
        logger.info("User creation test completed.");
    }

//    @Test(priority = 2)
    public void shouldDeleteJobTitles() {
        logger.info("Deleting job titles");
        jobTitlePage.clickDeleteJobTitleButton();
        // Verify success message after form submission
        String successMessage = jobTitlePage.getSuccessMessage(Constants.SUCCESS, Constants.SUCCESSFULLY_DELETED);
        Assert.assertTrue(successMessage.contains(Constants.SUCCESSFULLY_DELETED), "Expected 'Success' message not found");
        logger.info("User deletion test completed.");
    }

    @Test(priority = 3)
    public void shouldCancelDeleteJobTitles() {
        logger.info("Cancel Deleting job titles");
        jobTitlePage.clickToCancelDeleteJobTitleButton();
        // Verify success message after form submission
        String successMessage = jobTitlePage.getNoSuccessMessage(Constants.SUCCESS, Constants.SUCCESSFULLY_DELETED);
        Assert.assertTrue(successMessage.isEmpty(), "Unexpected success message was displayed: " + successMessage);
        logger.info("User cancel deletion test completed.");
    }

}
