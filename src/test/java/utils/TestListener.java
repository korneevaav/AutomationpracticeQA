package utils;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class TestListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        log.info(("======================================== STARTING TEST " + iTestResult.getName() + " ========================================"));

    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info(String.format("======================================== FINISHED TEST %s Duration: %ss ========================================%n", iTestResult.getName(),
                getExecutionTime(iTestResult)));

    }

    public void onTestFailure(ITestResult iTestResult) {
        log.info(String.format("======================================= FAILED TEST %s Duration: %ss ========================================%n", iTestResult.getName(),
                getExecutionTime(iTestResult)));
        takeScreenshot();
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.info(String.format("======================================== SKIPPING TEST %s ========================================%n", iTestResult.getName()));
        takeScreenshot();
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        try {
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (NoSuchSessionException | IllegalStateException ex) {
            return new byte[]{};
        }
    }


    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}