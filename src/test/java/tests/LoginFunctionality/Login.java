package tests.LoginFunctionality;

import ArmsProject.util.LoginBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.basetest.BaseTest;

public class Login extends BaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testLogInFunctionality() {
        LoginBase.logIn(baseURL, username, password);
    }
}
