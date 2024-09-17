package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCatalogue extends AbstractComponents {

    // Constructor to initialize WebDriver for ProductCatalogue page
    public ProductCatalogue(WebDriver driver) {
        super(driver);  // Call the constructor of AbstractComponents
    }

    // Web elements on the page defined using @FindBy annotation
    @FindBy(xpath = "//div[@class='inventory_item']")
    List<WebElement> products;  // List of all products available

    @FindBy(css = ".shopping_cart_link")
    WebElement cartHeader;  // Cart icon in the header

    // Locators for specific elements
    By productsBy = By.xpath("//div[@class='inventory_item']"); // Locator for all product elements
    By addToCart = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"); // Locator for the "Add to Cart" button

    // Method to get the list of all products displayed on the page
    public List<WebElement> getProductList() {
        waitForElementToAppear(productsBy);  // Wait until the product elements are visible
        return products;  // Return the list of products
    }

    // Method to find a product by its name from the product list
    public WebElement getProductByName(String productName) {
        WebElement prod = products.stream()  // Stream through the list of products
                .filter(product -> product.findElement(By.id("item_4_title_link"))
                .getText().equals(productName))  // Check if the product name matches
                .findFirst().orElse(null);  // Return the first matching product or null
        return prod;  // Return the found product WebElement
    }

    // Method to add a product to the cart by product name
    public void addProductToCart(String productName) {
        WebElement prod = getProductByName(productName);  // Find the product by name
        prod.findElement(addToCart).click();  // Click on "Add to Cart" button for the selected product
    }

    // Method to navigate to the Cart page
    public CartPage goToCartPage() {
        cartHeader.click();  // Click on the cart icon in the header
        CartPage cartPage = new CartPage(driver);  // Create an instance of the CartPage
        return cartPage;  // Return the CartPage object
    }
}
