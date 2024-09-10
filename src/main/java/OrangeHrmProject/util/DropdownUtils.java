package OrangeHrmProject.util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class DropdownUtils {
    public static void selectFirstOption(SelenideElement dropdownElement) {
        dropdownElement.shouldBe(Condition.visible).click();

        // Select the first option
        SelenideElement firstOption = $$(By.cssSelector(".oxd-select-text-input")).get(1);
        firstOption.shouldBe(Condition.visible).click();
        System.out.println(firstOption.getText());

    }
}
