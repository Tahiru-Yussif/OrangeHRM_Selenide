package OrangeHrmProject.pages.AdminPage;


import OrangeHrmProject.util.DropdownUtils;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class userManagementPage {
    private final SelenideElement adminButton = $(By.xpath("//span[text()='Admin']"));
    private final SelenideElement addUserButton = $(By.xpath("//button[text()=' Add ']"));
    private final SelenideElement addUserTitle = $(By.xpath("//h6[text()='Add User']"));
    private final SelenideElement userManagementTitle = $(By.cssSelector(".oxd-topbar-header-breadcrumb"));
    private final SelenideElement userRolesSelect = $(By.xpath("//div[contains(@class, 'oxd-select-wrapper')]"));


    public void clickAdminButton() {
        adminButton.shouldBe(Condition.visible).click();
        userManagementTitle.shouldBe(Condition.visible);
    }

    public void clickAddUserButton() {
        addUserButton.shouldBe(Condition.visible).click();
        addUserTitle.shouldBe(Condition.visible);
    }

    public void selectUserRole() {
//        userRolesSelect.shouldBe(Condition.visible).click();
        DropdownUtils.selectFirstOption(userRolesSelect);
    }
}
