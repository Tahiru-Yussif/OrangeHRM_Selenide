//package ArmsProject.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//
//public class quickCheckPage {
//    private static WebDriver driver = null;
//    private static  WebDriverWait wait;
//
//    // Constructor
//    public quickCheckPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public quickCheckPage waitForElement(WebDriver driver, String elementLocator) {
//        // Wait for the signIn button to be clickable
//        wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
//       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementLocator)));
//       return this;
//    }
//
//    // Method to perform a search
//    public quickCheckPage clickSignInButton() {
//        // Wait for the signIn button to be clickable
//        WebElement signInButton = driver.findElement(By.cssSelector("div.cursor-pointer"));
//        signInButton.click();
//        return this;
//    }
//
//    // Method to navigate to Images section
//    public quickCheckPage enterEmail(String email) {
//        // Wait for email input field to be visible
//        WebElement emailInput = driver.findElement(By.cssSelector("input[type='email']"));
//        emailInput.sendKeys(email);
//        return this;
//    }
//
//    public quickCheckPage enterPassword(String password) {
//        // Wait for email input field to be visible
//        WebElement emailInput = driver.findElement(By.cssSelector("input[type='password']"));
//        emailInput.sendKeys(password);
//        return this;
//    }
//
//    public quickCheckPage clickNextButton() {
//        // Wait for next button to be clickable
//        WebElement nextButton = driver.findElement(By.cssSelector("input[type='submit']"));
//        nextButton.click();
//        return this;
//    }
//
//    public  void clickSkipButton() {
//        // Wait for next button to be clickable
//        WebElement skipButton = driver.findElement(By.xpath("(//button)[3]"));
//        skipButton.click();
//    }
//}
