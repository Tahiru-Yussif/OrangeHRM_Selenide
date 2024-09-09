package OrangeHrmProject.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebdriverSetUp {
    private static WebDriver driver;

    public static WebDriver setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
  }

    public static void endTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
