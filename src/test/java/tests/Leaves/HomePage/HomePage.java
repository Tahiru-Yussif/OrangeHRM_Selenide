package tests.Leaves.HomePage;

import ArmsProject.util.leaveBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.basetest.BaseTest;

public class HomePage extends BaseTest {

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
    }

    @Test
    public void leaveHomePageTest()  {
        leaveBase.performLeaveHomePageTest(baseURL, username, password, leavePageURL);
    }
}

