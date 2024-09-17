package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends AbstractComponents {

    // Constructor to initialize WebDriver for the ConfirmationPage
    public ConfirmationPage(WebDriver driver) {
        super(driver);  // Call the parent class (AbstractComponents) constructor
    }

    // Web element for the confirmation message on the page
    @FindBy(css = ".complete-header")
    WebElement confirmMsg;  // Element that displays the confirmation message

    // Method to get the text of the confirmation message
    public String getConfirmationMesage() {
        return confirmMsg.getText();  // Return the text of the confirmation message
    }
}