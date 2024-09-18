package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends AbstractComponents {

    // Constructor to initialize WebDriver for the LandingPage
    public LandingPage(WebDriver driver) {
        super(driver);  // Call the parent class (AbstractComponents) constructor
    }

    // Web elements on the landing (login) page using @FindBy annotation
    @FindBy(id = "user-name")
	public WebElement userName;  // Username input field

    @FindBy(id = "password")
    public WebElement password;  // Password input field

    @FindBy(id = "login-button")
    public WebElement btnSubmit;  // Submit (login) button

    @FindBy(css = "h3[data-test='error']")
    WebElement errorMessage;  // Error message that appears when login fails

    // Method to perform login operation
    

    // Method to navigate to the login page URL
    public void goTo() {
        driver.get("https://www.saucedemo.com/");  // Navigate to the Swag Labs login page
    }

    // Method to get the error message when login fails
    public String getErrorMessage() {
        waitForWebElementToAppear(errorMessage);  // Wait for the error message to appear
        return errorMessage.getText();  // Return the error message text
    }
}