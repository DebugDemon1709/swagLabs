package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.LandingPage;
import pageObjects.ProductCatalogue;

public class BaseClass {
    public static WebDriver driver;
    public LandingPage landingPage;
    static Properties properties = new Properties();

    /**
     * Initializes the WebDriver based on the browser specified in the properties file.
     * @return WebDriver instance
     * @throws IOException if there is an issue loading the properties file
     */
    public WebDriver initializeDriver() throws IOException {
        // Load properties from the configuration file
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\utilities\\GlobalData.properties");
        properties.load(fileInputStream);
        
        // Get the browser type from properties file
        String browserName = properties.getProperty("browser");
        
        // Initialize WebDriver based on browser type
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            // Code for initializing Edge WebDriver (if needed)
        }
        
        // Configure WebDriver
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        return driver;
    }
    
    // Method to get productName from the properties file
    public String getProductNameFromProperties() {
        return properties.getProperty("productName");
    }

    /**
     * Takes a screenshot of the current browser window.
     * @parameter1 testCaseName name of the test case for naming the screenshot file
     * @parameter2 driver WebDriver instance
     * @return path of the screenshot file
     * @throws IOException if there is an issue saving the screenshot
     */
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        // Generate a timeStamp for the screenshot file name
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        
        // Take a screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        
        // Define the path and file name for the screenshot
        String filePath = System.getProperty("user.dir") + "//screenshots//" + testCaseName + timeStamp + ".png";
        File file = new File(filePath);
        
        // Save the screenshot to the defined path
        FileUtils.copyFile(source, file);
        
        return filePath;
    }

    /**
     * Sets up the test environment before each test method.
     * @return LandingPage instance for interacting with the landing page
     * @throws IOException if there is an issue initializing the WebDriver
     */
    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        driver = initializeDriver(); // Initialize WebDriver
        landingPage = new LandingPage(driver); // Create a LandingPage instance
        landingPage.goTo(); // Navigate to the application URL
        return landingPage;
    }
    
    public static ProductCatalogue loginAplication() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.userName.sendKeys(properties.getProperty("userName"));  // Enter the username
        landingPage.password.sendKeys(properties.getProperty("password"));  // Enter the password
        landingPage.btnSubmit.submit();  // Submit the login form

        // Navigate to the product catalog page after successful login
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;  // Return the ProductCatalogue object
    }
    
    /**
     * Cleans up the test environment after each test method.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser and quit WebDriver
        }
    }
}
