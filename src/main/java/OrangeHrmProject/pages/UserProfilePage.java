package OrangeHrmProject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserProfilePage {
    // logout page elements and actions
//    private final SelenideElement userProfileButton = $(By.cssSelector(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon"));
    private final SelenideElement userProfileButton = $(By.cssSelector(".oxd-topbar-header-userarea"));
    private final SelenideElement logoutButton = $(By.xpath("//ul//li/a[text()='Logout']"));
    private final SelenideElement orangeHRMLogo = $(By.cssSelector(".orangehrm-login-branding"));


    // Method to click on user profile button
    public void clickUserProfileButton() {
        userProfileButton.click();
    }

    // Method to click on log out option in user profile dropdown
    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void isDisplayedOrangeHRMLogo() {
        orangeHRMLogo.should(Condition.visible);
    }
}
