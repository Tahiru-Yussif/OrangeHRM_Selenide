package OrangeHrmProject.pages.JobPage;

import OrangeHrmProject.util.SuccessMessageUtils;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class JobTitlePage {
    private final SelenideElement adminButton = $(By.xpath("//span[text()='Admin']"));
    private final SelenideElement JobNavButton = $$(By.cssSelector(".oxd-topbar-body-nav-tab-item")).get(1);
    private final SelenideElement JobTitles = $$(By.cssSelector(".oxd-topbar-body-nav-tab-link")).first();
    private final SelenideElement JobTitleHeader = $(By.cssSelector(".oxd-text.oxd-text--h6.orangehrm-main-title"));
    private final SelenideElement AddJobTitleButton = $(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary"));
    private final SelenideElement AddJobTitleField = $$(By.cssSelector(".oxd-input.oxd-input--active")).get(1);
//    private final SelenideElement AddJobDescriptionField = $$(By.cssSelector(".oxd-textarea.oxd-textarea--active.oxd-textarea--resize-vertical")).first();
//    private final SelenideElement AddJobDescriptionField = $$(By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")).first();
private final SelenideElement AddJobDescriptionField = $x("//textarea[@placeholder='Type description here']");
    private final SelenideElement fileUploadButton = $x(("//input[@type='file']"));
    private final SelenideElement uploadedFileText = $((".oxd-file-input-div"));
    private final SelenideElement AddJobNoteField = $x("//textarea[@placeholder='Add note']");
    private final SelenideElement saveButton = $(By.xpath("//button[@type='submit']"));
    private final SelenideElement successfulSavedMessage = $(By.cssSelector(".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text"));
    private final  SelenideElement successMessage = $(By.cssSelector(".oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text"));
    private final SelenideElement deleteJobTitleButton = $$x("//i[@class='oxd-icon bi-trash']").first();
    private final SelenideElement yesJobDeleteButton = $(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin"));
    private final SelenideElement cancelJobDeleteButton = $(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--ghost.orangehrm-button-margin"));

    public void clickAdminButtonAndNavigateToJobPage() {
        adminButton.shouldBe(Condition.visible).click();
        JobNavButton.shouldBe(Condition.visible).click();
        JobTitles.click();
        JobTitleHeader.shouldBe(Condition.visible);
    }

    public void clickAddJobTitleButton() {
        AddJobTitleButton.shouldBe(Condition.visible).click();
    }

    public void enterJobTitle(String jobTitle) {
        AddJobTitleField.shouldBe(Condition.visible).setValue(jobTitle);
    }

    public void enterJobDescription(String jobDescription) {
        AddJobDescriptionField.shouldBe(Condition.visible).setValue(jobDescription); // Enter the value
        AddJobDescriptionField.shouldHave(Condition.value(jobDescription)); // Assert the value
    }


    public void enterJobNote(String jobNote) {
        AddJobNoteField.shouldBe(Condition.visible).setValue(jobNote);
        AddJobNoteField.shouldHave(Condition.value(jobNote)); // Assert the value
    }

    public void uploadJobTitleFile(String filePath) {
        File file = new File(filePath);
        String expectedFileName =  file.getName();
        fileUploadButton.uploadFile(file);
        uploadedFileText.shouldHave(Condition.text(expectedFileName)); // Assert the uploaded file name in success message
    }

    public void clickSaveButton() {
        saveButton.shouldBe(Condition.enabled).click();
    }

    public String getSuccessMessage(String expectedSuccess, String expectedSaved) {
        return SuccessMessageUtils.fetchSuccessMessage(successMessage, successfulSavedMessage, expectedSuccess, expectedSaved);
    }

    public String getNoSuccessMessage(String expectedSuccess, String expectedSaved) {
        return SuccessMessageUtils.fetchNoSuccessMessage(successMessage, successfulSavedMessage, expectedSuccess, expectedSaved);
    }

    // Delete Job Title
    public void clickDeleteJobTitleButton() {
        deleteJobTitleButton.shouldBe(Condition.visible).click();
        yesJobDeleteButton.shouldBe(Condition.visible).click();
    }

    public void clickToCancelDeleteJobTitleButton() {
        deleteJobTitleButton.shouldBe(Condition.visible).click();
        cancelJobDeleteButton.shouldBe(Condition.visible).click();
    }
}
