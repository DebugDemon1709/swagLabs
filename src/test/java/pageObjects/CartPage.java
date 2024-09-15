package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractComponents {

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className = "inventory_item_name")
	private List<WebElement> cartProducts;
	
	
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
	

}

//List<WebElement> cartProducts = driver.findElements(By.className("inventory_item_name"));
//boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));