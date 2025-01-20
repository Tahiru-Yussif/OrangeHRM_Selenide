package OrangeHrmProject.util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.cssSelector;

public class DropdownUtils {
    public static void selectFirstOption() {
        SelenideElement dropdownElement = $$(cssSelector(".oxd-select-option")).get(1);
        dropdownElement.click();
        // Wait for the first option to be clickable and then click it
        SelenideElement firstOption = $$(cssSelector(".oxd-select-text-input")).get(0);
        firstOption.shouldBe(Condition.visible, Condition.clickable).click();
        System.out.println(firstOption.getText());
    }

//    public static void selectDropdownOption(SelenideElement dropdown, int optionIndex) {
//        // Click to open the dropdown
//        dropdown.click();
//
////        // Move down through the dropdown options using arrow keys and select the option
////        for (int i = 0; i < optionIndex; i++) {
////            dropdown.sendKeys(Keys.ARROW_DOWN);
////        }
////
////        // Press Enter to select the current highlighted option
////        dropdown.sendKeys(Keys.ENTER);
//    }
}
