package utils.reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class Listeners implements ITestListener {

    private static ExtentReports extent = extenReportManager.getReportObject();

    @Override
    public void onTestStart(ITestResult result) {
        // Code to execute when a test starts
        ExtentTestManager.setTest(extent.createTest(result.getMethod().getMethodName()));

        ExtentTestManager.getTest().log(
                Status.INFO,
                "Test Started"
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Code to execute when a test passes
        ExtentTestManager.getTest().log(
                Status.PASS,
                "Test Passed"
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Code to execute when a test fails
        ExtentTestManager.getTest().log(
                Status.FAIL,
                "Test Failed"
        );
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Code to execute when a test is skipped
        ExtentTestManager.getTest()
                .skip("Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Code to execute when a test fails but is within the success percentage
    }

    @Override
    public void onStart(ITestContext context) {
        // Code to execute before any tests are run
    }

    @Override
    public void onFinish(ITestContext context) {
        // Code to execute after all tests have run
        extent.flush();
        ExtentTestManager.removeTest();

    }
}
