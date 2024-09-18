package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.InformationPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseClass;

public class TC001_SubmitOrderTest extends BaseClass {
	
	String productName = "Sauce Labs Backpack";
	@Test
	public void submitOrder() {
		// Go to LandingPage and Login
		ProductCatalogue productCatalogue = BaseClass.loginAplication();
		
        // Get the list of products, add to cart desired product
		productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);

        // Go to Cart Page and verify product
        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);

        // Go to Information Page and enter random information
        InformationPage informationPage = cartPage.goToInformationPage();
        informationPage.enterRandomString();
        informationPage.goToCheckoutPage();

        // Go to Checkout Page and confirm order
        CheckoutPage checkoutPage = informationPage.goToCheckoutPage();
        checkoutPage.clickFinish();
        checkoutPage.goToConfirmationPage();

        // Get confirmation message
        ConfirmationPage confirmationPage = checkoutPage.goToConfirmationPage();
        String confirmationMessage = confirmationPage.getConfirmationMesage();
        Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thank you for your order!"));    
	}
}