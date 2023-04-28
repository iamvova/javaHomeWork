package javaLabs.lab14;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static javaLabs.lab12.WebDriverSupplier.driver;

public class AllureListener implements ITestListener {

    private final Logger LOGGER = Logger.getLogger(this.getClass());
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        LOGGER.info(result.getName() + " Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        LOGGER.info(result.getName() + " Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        LOGGER.info(result.getName() + " Failure");
        makeScreenShot();
    }

    @Attachment(value="Page screen", type="image/png")
    private byte[] makeScreenShot(){
        LOGGER.error(" Error ----->");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }
}
