package tests.basetest;

import OrangeHrmProject.util.AppConfig;
import OrangeHrmProject.util.JsonDataReader;
import OrangeHrmProject.util.RoutesConfig;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import com.codeborne.selenide.Configuration;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    public static String baseURL;
    public String dashboardURL;
    public static String validUsername;
    public static String validPassword;
    public static String invalidUsername;
    public static String invalidPassword;
    public static String userManagementPageUrl;
    protected JsonNode jsonData;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void setUp() {
        // Set Selenide configuration
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";  // Set browser size instead of startMaximized
        Configuration.timeout = 10000;

        // Load URLs and other configurations from AppConfig
        baseURL = AppConfig.getBaseURL();
        dashboardURL = AppConfig.getDashboardURL();
        userManagementPageUrl = RoutesConfig.userManagementPageUrl();
        validUsername = AppConfig.getValidUsername();
        validPassword = AppConfig.getValidPassword();
        invalidPassword = AppConfig.getInvalidUsername();
        invalidUsername = AppConfig.getInvalidPassword();

        // Load JSON data
        try {
            jsonData = JsonDataReader.loadJsonData("src/main/resources/data/testData.json");
        } catch (IOException e) {
            logger.error("Failed to load JSON data", e);
            Assert.fail("Failed to load JSON data");
        }

        // Log base URL
        logger.info("Base URL is set to: " + baseURL);
    }

    @AfterSuite
    public void tearDown() {
        // Close the browser
        closeWebDriver();
        logger.info("WebDriver closed and test suite teardown complete.");
    }
}
