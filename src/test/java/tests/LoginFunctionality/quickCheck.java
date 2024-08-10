//package LoginFunctionality;
//
//import ArmsProject.factory.User;
//import ArmsProject.pages.LoginPage;
//import ArmsProject.util.AppConfig;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//
//public class quickCheck {
//
//    private WebDriver driver;
//    private String baseURL;
//    private String username;
//    private String password;
//
//    @BeforeClass
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        baseURL = AppConfig.getBaseURL(); // Retrieve base URL from AppConfig
//        username = AppConfig.getUsername();
//        password = AppConfig.getPassword();
//    }
//
//    @Test
//    public void logIn() throws InterruptedException {
//        driver.get("https://armsent-test.amalitech-dev.net/login");
//
////        // Instantiate POM objects
//        LoginPage signInPage = new LoginPage(driver);
//
////        // Perform signIn
//
//        signInPage.waitForElement(driver,"div.cursor-pointer")
//                .clickSignInButton()
//                .waitForElement(driver,"input[type='email']")
//                .enterEmail(username)
//                .clickNextButton()
//                .waitForElement(driver,"input[type='password']")
//                .enterPassword(password)
//                .clickNextButton()
//        ;
//
//
//
//        Thread.sleep(5000);
//        signInPage.clickSkipButton();
//
//        // Get the current URL & expected URL
//        String currentUrl = driver.getCurrentUrl();
//        String expectedURL = baseURL;
//
//
//        // Assert that the current URL matches the expected URL
//        Assert.assertEquals(currentUrl, expectedURL, "URLs do not match");
//
//        // skip button
//
//    }
//
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
