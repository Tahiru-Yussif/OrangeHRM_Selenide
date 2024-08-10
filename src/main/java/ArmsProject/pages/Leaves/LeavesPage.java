package ArmsProject.pages.Leaves;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

public class LeavesPage {
    private final SelenideElement appsIcon = $(By.className("appsIcon"));
    private final SelenideElement leaveIcon = $(By.linkText("Leave Manager"));
    private final SelenideElement settingsItem = $(cssSelector("[data-cy='settingsItem']"));

    public void clickAppsIcon() {
        appsIcon.click();
    }

    public void clickLeaveIcon() {
        leaveIcon.click();
    }

    public void settingItemButton() {
        settingsItem.click();
    }

}
