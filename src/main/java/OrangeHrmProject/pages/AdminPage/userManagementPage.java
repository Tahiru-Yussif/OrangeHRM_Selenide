package OrangeHrmProject.pages.AdminPage;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class userManagementPage {
    private final SelenideElement adminButton = $(By.xpath("//span[text()='Admin']"));
    private final SelenideElement userManagementTitle = $(By.cssSelector(".oxd-topbar-header-breadcrumb"));


    public void clickAdminButton() {
        adminButton.shouldBe(Condition.visible).click();
        userManagementTitle.shouldBe(Condition.visible);
    }
}
