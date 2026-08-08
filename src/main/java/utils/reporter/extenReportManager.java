package utils.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extenReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportObject()
    {
        String path = System.getProperty("user.dir")
                + "/test-output/ExtentReport.html";

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(path);

        reporter.config().setReportName("SauceDemo Automation Report");
        reporter.config().setDocumentTitle("Test Execution Report");
        extent = new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo("Application", "SauceDemo");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Tester", "Rahul");

        return extent;

    }
}
