package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractComponents {
	WebDriver driver;
	WebDriverWait wait;
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void waitForElementToAppear(By findBy) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findEle) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findEle));
	}
	public void waitForWebElementToBeClickable(WebElement clkElement) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait for up to 10 seconds
        wait.until(ExpectedConditions.elementToBeClickable(clkElement));  // Wait for the button to be clickable
	}
}