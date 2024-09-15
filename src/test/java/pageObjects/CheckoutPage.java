package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractComponents {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name = "firstName")
	WebElement firstName;
	@FindBy(name = "lastName")
	WebElement lastName;
	@FindBy(name = "postalCode")
	WebElement postalCode; 
	@FindBy(id = "continue")
	WebElement btnContinue;
	@FindBy(id = "finish")
	WebElement btnfinish;
	
	public void enterDetails(String fName, String lName, String pCode) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		postalCode.sendKeys(pCode);
	}
	public ConfirmationPage clickContinue() {
		btnContinue.click();
		btnfinish.click();
		return new ConfirmationPage(driver);
	}
	
	
}
