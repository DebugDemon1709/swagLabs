package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationPage extends AbstractComponents {

	public InformationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "firstName")
	WebElement firstName;
	@FindBy(name = "lastName")
	WebElement lastName;
	@FindBy(name = "postalCode")
	WebElement postalCode;
	@FindBy(css = "#continue")
	WebElement btnContinue;

	public void enterInformation(String fName, String lName, String pCode) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		postalCode.sendKeys(pCode);
	}

	public void enterRandomString() {
		String randomFirstName = RandomStringUtils.randomAlphabetic(7); // 7 characters long
		String randomLastName = RandomStringUtils.randomAlphabetic(10); // 10 characters long
		String randomPostalCode = RandomStringUtils.randomNumeric(5);
		enterInformation(randomFirstName, randomLastName, randomPostalCode);
		btnContinue.sendKeys(Keys.PAGE_DOWN);
		btnContinue.click();
	}

	public CheckoutPage goToCheckoutPage() {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
}