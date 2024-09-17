package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractComponents {

    // Constructor to initialize WebDriver for the CheckoutPage
    public CheckoutPage(WebDriver driver) {
        super(driver);  // Call the parent class (AbstractComponents) constructor
    }

    // Web element for the "Finish" button on the checkout page
    @FindBy(css = "#finish")
    WebElement btnfinish;  // Button to finalize the purchase

    // Method to click the "Finish" button
    public void clickFinish() {
        waitForWebElementToBeClickable(btnfinish);  // Wait until the "Finish" button is clickable
        btnfinish.click();  // Click the "Finish" button
    }

    // Method to navigate to the Confirmation page
    public ConfirmationPage goToConfirmationPage() {
        return new ConfirmationPage(driver);  // Create and return a new instance of ConfirmationPage
    }
}
