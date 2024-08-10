package ArmsProject.util;

import ArmsProject.pages.Leaves.LeavesPage;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class leaveBase {

    public static void performLeaveHomePageTest(String baseURL, String username, String password, String leavePageURL) {
        LoginBase.logIn(baseURL, username, password);

        // Continue with the leave page test
        LeavesPage leavePage = new LeavesPage();
//        sleep(2000);
        leavePage.clickAppsIcon();
        leavePage.clickLeaveIcon();

        sleep(2000);

        // Get the current URL and expected URL
        String currentUrl = url();

        // Assert that the current URL matches the expected URL
        Assert.assertEquals(currentUrl, leavePageURL, "URLs do not match");
    }

}
