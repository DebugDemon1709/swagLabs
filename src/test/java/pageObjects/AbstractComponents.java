package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
    WebDriver driver;    // WebDriver instance for interacting with the browser
    WebDriverWait wait;  // WebDriverWait instance for explicit waits

    // Constructor for initializing WebDriver and PageFactory elements
    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize all WebElements for the current page
    }

    // Waits for a specific element to be visible on the page (using By locator)
    public void waitForElementToAppear(By findBy) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Set explicit wait for 5 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy)); // Wait for the element to be visible
    }

    // Waits for a specific WebElement to be visible on the page
    public void waitForWebElementToAppear(WebElement findEle) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Set explicit wait for 5 seconds
        wait.until(ExpectedConditions.visibilityOf(findEle)); // Wait for the WebElement to be visible
    }

    // Waits for a specific WebElement to become clickable (useful for buttons)
    public void waitForWebElementToBeClickable(WebElement clkElement) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set explicit wait for 10 seconds
        wait.until(ExpectedConditions.elementToBeClickable(clkElement)); // Wait until the WebElement is clickable
    }
}