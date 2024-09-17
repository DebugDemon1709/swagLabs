package testComponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentReporterNG;

public class Listeners extends BaseClass implements ITestListener {
    // Create an instance of ExtentReports to generate the test report
    ExtentReports extent = ExtentReporterNG.getReportObject();
    // Create an ExtentTest instance to log individual test results
    ExtentTest test;
    // ThreadLocal to ensure thread safety for ExtentTest instance
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test entry in the report with the test method name
        test = extent.createTest(result.getMethod().getMethodName());
        // Store the test entry in ThreadLocal for thread safety
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log a success status for the test in the report
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log a failure status for the test in the report
        extentTest.get().log(Status.FAIL, "Test failed");
        extentTest.get().fail(result.getThrowable());
        try {
            // Retrieve WebDriver instance from the test class
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            // Capture screenshot and add it to the report
            String filePath = getScreenshot(result.getMethod().getMethodName(), driver);
            extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
        } catch (Exception e) {
            // Print stack trace if there's an error retrieving the WebDriver or adding the screenshot
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional: Handle tests that fail but are within the success percentage criteria (if any)
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the report to write all test results to the report file
        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Optional: Handle skipped tests (if needed)
    }
}