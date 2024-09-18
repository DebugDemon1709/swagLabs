package testCases;

import org.testng.annotations.Test;

import pageObjects.ProductCatalogue;
import testComponents.BaseClass;

public class TC003_LogoutTest extends BaseClass {
	@Test
	public void verify_Logout() {
		ProductCatalogue productCatalogue = BaseClass.loginAplication();
		productCatalogue.logout();
	}

}
