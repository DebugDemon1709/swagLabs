package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseClass;

public class TC002_ErrorValidationTest extends BaseClass {

	String productName = "Sauce Labs Backpack";
	@Test
	public void errorValidation() {
		// Go to LandingPage and Login
		ProductCatalogue productCatalogue = BaseClass.loginAplication();  //from BaseClass

		// Get the list of products, add to cart desired product
		productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);

		// Go to Cart Page and verify product
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay("Sauce Labs Bag"); // Error validation with invalid productName
		Assert.assertFalse(match); //testing assertFalse
	}
}