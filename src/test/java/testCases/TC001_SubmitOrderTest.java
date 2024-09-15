package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseClass;

public class TC001_SubmitOrderTest extends BaseClass {
	
	String productName = "Sauce Labs Backpack";
	@Test
	public void submitOrder() {
		ProductCatalogue productCatalogue = landingPage.loginAplication("standard_user", "secret_sauce");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		
		
		
		
	}

}
