package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractComponents {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#finish")
	WebElement btnfinish;
	
	public void clickFinish() {
		waitForWebElementToBeClickable(btnfinish);
		btnfinish.click();
	}
	
	public ConfirmationPage goToConfirmationPage() {
		return new ConfirmationPage(driver);
	}
}
