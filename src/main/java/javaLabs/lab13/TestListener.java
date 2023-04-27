package javaLabs.lab13;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private final Logger LOGGER = Logger.getLogger(this.getClass());
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        LOGGER.info(result.getName() + " onTestFailedWithTimeout");
    }
    @Override
    public void onFinish(ITestContext context) {
        LOGGER.info(context.getName() + " onFinish");
    }


}
