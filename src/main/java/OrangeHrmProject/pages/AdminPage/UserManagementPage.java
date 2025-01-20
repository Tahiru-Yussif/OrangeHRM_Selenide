package OrangeHrmProject.pages.AdminPage;

import OrangeHrmProject.util.DropdownUtils;
import OrangeHrmProject.util.SuccessMessageUtils;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;

public class UserManagementPage {
    private final SelenideElement adminButton = $(By.xpath("//span[text()='Admin']"));
    private final SelenideElement addUserButton = $(By.xpath("//button[text()=' Add ']"));
    private final SelenideElement addUserTitle = $(By.xpath("//h6[text()='Add User']"));
    private final SelenideElement userManagementTitle = $(By.cssSelector(".oxd-topbar-header-breadcrumb"));
    private final SelenideElement userRolesSelect = $$(By.xpath("//div[contains(@class, 'oxd-select-wrapper')]")).first();
    private final SelenideElement userStatusSelect = $$(By.xpath("//div[contains(@class, 'oxd-select-wrapper')]")).get(1);
    private final ElementsCollection userPasswordField = $$(By.xpath("//input[@type='password']"));
    private final SelenideElement confirmUserPasswordField = userPasswordField.get(1);
    private final SelenideElement userNameField = $("input[autocomplete='off']");
    private final SelenideElement employeeNameField = $("input[placeholder='Type for hints...']");
    private final SelenideElement selectEmployeeName = $(By.xpath("//div[@role='listbox']"));
    private final SelenideElement submitButton = $(By.xpath("//button[@type='submit']"));
    private final SelenideElement successfulSavedMessage = $(By.cssSelector(".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text"));
    private final  SelenideElement successMessage = $(By.cssSelector(".oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text"));
    private final SelenideElement userPasswordErrorMessage = $$(By.cssSelector(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")).get(4);
    private final SelenideElement employeeNameErrorMessage = $$(By.cssSelector(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")).get(1);

    public void clickAdminButton() {
        adminButton.shouldBe(Condition.visible).click();
        userManagementTitle.shouldBe(Condition.visible);
    }

    public void clickAddUserButton() {
        addUserButton.shouldBe(Condition.visible).click();
        addUserTitle.shouldBe(Condition.visible);
    }

    public void selectUserRole() {
        userRolesSelect.shouldBe(Condition.visible).click();
        DropdownUtils.selectFirstOption();
    }

    public void selectStatus() {
        userStatusSelect.shouldBe(Condition.visible).click();
        DropdownUtils.selectFirstOption();
    }

    public void enterEmployeeName(String employeeName) {
        employeeNameField.shouldBe(Condition.visible).setValue(employeeName);
        sleep(2000);
        selectEmployeeName.shouldBe(Condition.visible).click();
    }

    public void enterUserName(String userName) {
        // Get current time (hours, minutes, seconds)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        String uniqueSuffix = LocalDateTime.now().format(formatter);

        // Append the unique time suffix to the username
        String uniqueUserName = userName + uniqueSuffix;

        // Enter the unique username in the field
        userNameField.shouldBe(Condition.visible).setValue(uniqueUserName);
    }

    // Enter the password in the first password field
    public void enterUserPassword(String password) {
        userPasswordField.first().shouldBe(Condition.visible).setValue(password);
    }

    // Confirm the password in the second password field
    public void confirmUserPassword(String password) {
        confirmUserPasswordField.shouldBe(Condition.visible).setValue(password);
    }

    public void clickSubmitButton() {
        submitButton.shouldBe(Condition.enabled).click();
    }

    public String getUserPasswordErrorMessage() {
        return userPasswordErrorMessage.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText();
    }

    public String getEmployeeNameErrorMessage() {
        return employeeNameErrorMessage.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText();
    }

    public String getSuccessMessage(String expectedSuccess, String expectedSaved) {
        return SuccessMessageUtils.fetchSuccessMessage(successMessage, successfulSavedMessage, expectedSuccess, expectedSaved);
    }

}
