package OrangeHrmProject.util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class SuccessMessageUtils {
    public static String fetchSuccessMessage(SelenideElement successMessageElement, SelenideElement savedMessageElement,
                                             String expectedSuccess, String expectedSaved) {
        // Check for both success messages
        if (successMessageElement.shouldBe(Condition.visible, Duration.ofSeconds(10)).has(Condition.text(expectedSuccess)) &&
                savedMessageElement.shouldBe(Condition.visible, Duration.ofSeconds(10)).has(Condition.text(expectedSaved))) {
            return successMessageElement.getText() + " & " + savedMessageElement.getText();
        }

        // Check for only the "Success" message
        if (successMessageElement.shouldBe(Condition.visible, Duration.ofSeconds(10)).has(Condition.text(expectedSuccess))) {
            return successMessageElement.getText();
        }

        // Check for only the "Successfully Saved" message
        if (savedMessageElement.shouldBe(Condition.visible, Duration.ofSeconds(10)).has(Condition.text(expectedSaved))) {
            return savedMessageElement.getText();
        }

        // Return a default message if none are found
        return "No success message found";
    }

    public static String fetchNoSuccessMessage(SelenideElement successMessageElement, SelenideElement savedMessageElement,
                                               String expectedSuccess, String expectedSaved) {
        // Check if neither message is visible
        if (!successMessageElement.is(Condition.visible) && !savedMessageElement.is(Condition.visible)) {
            return "No success message found";
        }

//        // Check if the "Success" message is visible
//        if (successMessageElement.is(Condition.visible) && successMessageElement.has(Condition.text(expectedSuccess))) {
//            return successMessageElement.getText();
//        }
//
//        // Check if the "Successfully Saved" message is visible
//        if (savedMessageElement.is(Condition.visible) && savedMessageElement.has(Condition.text(expectedSaved))) {
//            return savedMessageElement.getText();
//        }
//
//        // If both are visible, return their text combined
//        if (successMessageElement.is(Condition.visible) && savedMessageElement.is(Condition.visible)) {
//            return successMessageElement.getText() + " & " + savedMessageElement.getText();
//        }

        // Default case if no relevant condition matches
        return "No success message found";
    }

}
