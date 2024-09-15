package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCatalogue extends AbstractComponents {

	public ProductCatalogue(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//div[@class='inventory_item']")
	List<WebElement> products;
	@FindBy(css = ".shopping_cart_link")
	WebElement cartHeader;
	By productsBy = By.xpath("//div[@class='inventory_item']");
	By addToCart = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");
	
	
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod = products.stream().filter(product->  // searching  inside "products" list
		product.findElement(By.id("item_4_title_link")).getText().equals(productName)).findFirst().orElse(null); 
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
	}
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	

}
