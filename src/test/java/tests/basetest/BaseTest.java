package tests.basetest;

import ArmsProject.util.AppConfig;
import ArmsProject.util.Leaves.LeavesType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

//    public WebDriver driver;
    public static String baseURL;
    public String leavePageURL;
    public static String username;
    public static String password;
    public static String leaveTypeName;

    @BeforeClass
    public void setUp() {
        // Set Selenide configuration
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";  // Set browser size instead of startMaximized
        Configuration.timeout = 10000;
        Configuration.baseUrl = AppConfig.getBaseURL();
        // Load URLs and other configurations from AppConfig
        baseURL = AppConfig.getBaseURL();
        leavePageURL = AppConfig.getLeavePageURL();
        username = AppConfig.getUsername();
        password = AppConfig.getPassword();
        leaveTypeName = LeavesType.getLeaveTypeName();
    }

    @AfterSuite
    public void tearDown() {
        // Close the browser
        closeWebDriver();

        // Flush the ExtentReports
//        this.extent.flush();
    }
}
