package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
    
    // Method to initialize and configure ExtentReports
    public static ExtentReports getReportObject() {
        // Generate a timeStamp to create a unique report file name
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "Report-" + timeStamp + ".html";  // Report file name with timeStamp
        String path = System.getProperty("user.dir") + "//reports//" + reportName;  // Path to save the report
        
        // Create an instance of ExtentSparkReporter with the specified file path
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");  // Set the report name
        reporter.config().setDocumentTitle("Test Results");  // Set the document title
        reporter.config().setTheme(Theme.DARK);  // Set the theme of the report
        
        // Create an instance of ExtentReports and attach the reporter to it
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        
        // Set system information for the report
        extent.setSystemInfo("TestEngineer", "SRIKANTH V");  // Name of the test engineer
        extent.setSystemInfo("Application", "demo_E-com");  // Application under test
        
        return extent;  // Return the configured ExtentReports instance
    }
}
