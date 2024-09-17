package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationPage extends AbstractComponents {

    // Constructor to initialize WebDriver for InformationPage
    public InformationPage(WebDriver driver) {
        super(driver);  // Call the parent class (AbstractComponents) constructor
    }

    // Web elements on the information input page defined using @FindBy annotation
    @FindBy(name = "firstName")
    WebElement firstName;  // Input field for the first name

    @FindBy(name = "lastName")
    WebElement lastName;  // Input field for the last name

    @FindBy(name = "postalCode")
    WebElement postalCode;  // Input field for the postal code

    @FindBy(css = "#continue")
    WebElement btnContinue;  // Button to continue to the next step

    // Method to enter provided first name, last name, and postal code
    public void enterInformation(String fName, String lName, String pCode) {
        firstName.sendKeys(fName);  // Enter the first name
        lastName.sendKeys(lName);  // Enter the last name
        postalCode.sendKeys(pCode);  // Enter the postal code
    }

    // Method to enter random strings for first name, last name, and postal code
    public void enterRandomString() {
        String randomFirstName = RandomStringUtils.randomAlphabetic(7);  // Generate a random first name (7 characters)
        String randomLastName = RandomStringUtils.randomAlphabetic(10);  // Generate a random last name (10 characters)
        String randomPostalCode = RandomStringUtils.randomNumeric(5);  // Generate a random postal code (5 digits)
        
        enterInformation(randomFirstName, randomLastName, randomPostalCode);  // Call the method to enter random data
        
        btnContinue.sendKeys(Keys.PAGE_DOWN);  // Scroll down to make the continue button visible
        btnContinue.click();  // Click the continue button
    }

    // Method to navigate to the Checkout page after entering the information
    public CheckoutPage goToCheckoutPage() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);  // Create an instance of CheckoutPage
        return checkoutPage;  // Return the CheckoutPage object
    }
}
