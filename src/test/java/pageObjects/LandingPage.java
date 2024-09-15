
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends AbstractComponents {
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "user-name")//158
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "login-button")
	WebElement btnSubmit;
	@FindBy(css = "h3[data-test='error']")
	WebElement errorMessage;
	
	public ProductCatalogue loginAplication(String name, String pwd) {
		userName.sendKeys(name);
		password.sendKeys(pwd);
		btnSubmit.submit();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	public void goTo() {
		driver.get("https://www.saucedemo.com/");
	}
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
