package listeners;

import base.DriverFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtils.capture(
                DriverFactory.getDriver(),
                result.getMethod().getMethodName()
        );
        System.err.println("FAILED: " + result.getName() + " | Screenshot: " + path);
    }
}
