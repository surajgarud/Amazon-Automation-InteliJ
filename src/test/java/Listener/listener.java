package Listener;

import Base.TestBase;
import Utility.utilityclass;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class listener extends TestBase implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.pass("Test successfull");
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" :onTestStart");
        extent.attachReporter(spark);
        extent.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        utilityclass utilityclass = new utilityclass();
        String testName = result.getMethod().getMethodName();
        try {
            utilityclass.screenshot(testName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.fail("Test failed");
        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
            ExtentTest test = extent.createTest(result.getMethod().getMethodName());
            test.skip("Test skipped");
            extent.flush();
    }


}
