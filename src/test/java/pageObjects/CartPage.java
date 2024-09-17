package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractComponents {

    // Constructor to initialize WebDriver for CartPage
    public CartPage(WebDriver driver) {
        super(driver);  // Call the parent class (AbstractComponents) constructor
    }

    // Web elements on the Cart page defined using @FindBy annotation
    @FindBy(className = "inventory_item_name")
    private List<WebElement> cartProducts;  // List of product names in the cart

    @FindBy(css = "#checkout")
    WebElement btnCheckout;  // Button to proceed to the checkout page

    // Method to verify if a specific product is displayed in the cart
    public Boolean verifyProductDisplay(String productName) {
        // Check if any product in the cart matches the specified product name (case-insensitive)
        Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;  // Return the result of the check
    }

    // Method to navigate to the Information page
    public InformationPage goToInformationPage() {
        btnCheckout.click();  // Click the checkout button to proceed
        // Create and return a new instance of InformationPage
        InformationPage informationPage = new InformationPage(driver);
        return informationPage;
    }
}