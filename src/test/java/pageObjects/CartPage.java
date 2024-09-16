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
	@FindBy(css = "#checkout")
	WebElement btnCheckout;
	
	
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
	public InformationPage goToInformationPage() {
		btnCheckout.click();
		InformationPage informationPage = new InformationPage(driver);
		return informationPage;
	}
}