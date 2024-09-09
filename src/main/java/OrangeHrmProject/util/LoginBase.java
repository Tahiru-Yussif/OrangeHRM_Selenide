package OrangeHrmProject.util;

import OrangeHrmProject.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class LoginBase {

    private static final Logger logger = LogManager.getLogger(LoginBase.class);

    public static void logIn(String baseURL, String username, String password) {
        logger.info("Navigating to login page at: " + baseURL);

        // Open the login page
        open(baseURL);

        // Instantiate the LoginPage object
        LoginPage loginPage = new LoginPage();

        // Perform login
        loginPage.login(username, password);
    }
}
