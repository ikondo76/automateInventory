package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    // Main report object (shared for the whole suite)
    private static ExtentReports extent;

    // Represents one individual test in the report
    private static ExtentTest extentTest;

    // Runs BEFORE every single test method starts
    @Override
    public void onTestStart(ITestResult result) {

        extentTest = extent.createTest(result.getMethod().getMethodName());
    }

    // Runs when a test FAILS
    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.log(Status.FAIL, "Test Case " + result.getMethod().getMethodName() + " Has failed");
    }

    // Runs when a test PASSES
    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.log(Status.PASS, "Test Case " + result.getMethod().getMethodName() + " Has passed");
    }

    // Runs when a test is SKIPPED (e.g., due to dependency failure)
    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.log(Status.SKIP, "Test Case " + result.getMethod().getMethodName() + " Has been skipped");
    }

    @Override
    public void onFinish(ITestContext result) {
        // VERY IMPORTANT: Writes everything to the HTML file
        // Without flush(), the report will be empty or incomplete
        extent.flush();
    }

    // Runs ONCE before any test in the suite starts
    @Override
    public void onStart(ITestContext result) {
        // Initialize the report using our manager class
        extent = ExtentReportManager.extentReports();

    }
}
