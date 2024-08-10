package tests.Leaves.Settings;

import ArmsProject.util.leaveBase;
import ArmsProject.pages.Leaves.LeaveType;
import com.aventstack.extentreports.configuration.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.basetest.BaseTest;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LeavesType extends BaseTest {
    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        leaveBase.performLeaveHomePageTest(baseURL, username, password, leavePageURL);
    }

    @Test(description = "test description")
    public void performAddLeaveTypeTest() {
        // instantiate LeavePage
        LeaveType leaveType = new LeaveType();
        leaveType.settingItemButton();

        // Perform add leave type action
        leaveType.clickAddLeaveTypeButton();
        // add leave type name
        leaveType.addLeaveTypeName(leaveTypeName);
        sleep(2000);

        Assert.assertEquals(url(), leavePageURL + "leave-type", "URLS doesn't match");
    }
}
