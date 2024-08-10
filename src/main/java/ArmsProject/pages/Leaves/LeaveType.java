package ArmsProject.pages.Leaves;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

public class LeaveType {
    private final SelenideElement addLeaveTypeButton = $(cssSelector("[data-cy='addLeaveType']"));
    private final SelenideElement settingsItem = $(cssSelector("[data-cy='settingsItem']"));
    private final SelenideElement leaveTypeName = $(cssSelector("input[data-cy='name']"));


    public void clickAddLeaveTypeButton() {
        addLeaveTypeButton.click();
    }

    public void settingItemButton() {
        settingsItem.click();
    }

    public void addLeaveTypeName(String name) {
        String LeaveTypeNameValue = name + " " + System.currentTimeMillis();
        leaveTypeName.shouldBe(visible).click();
        leaveTypeName.setValue(LeaveTypeNameValue);
        leaveTypeName.shouldHave(value(LeaveTypeNameValue));
    }
}
