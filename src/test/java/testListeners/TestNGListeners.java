package testListeners;

import driver.BaseClass;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.*;
import utils.GenericFunction;
import utils.GlobalVar;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

public class TestNGListeners extends BaseClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        GenericFunction.removeFilesFromFolder("videos", ".mov");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        try {
            Allure.addAttachment("Failure Logs", getLogs());
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(xScreenShot()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(xScreenShot()));
            Allure.addAttachment("Failure Logs", getLogs());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(xScreenShot()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}

    @Override
    public void onStart(ITestContext iTestContext) {}

    @Override
    public void onFinish(ITestContext iTestContext) {}

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Test Screenshot", type = "image/png")
    public byte[] xScreenShot() {
        return ((TakesScreenshot) BaseClass.webDriver).getScreenshotAs(OutputType.BYTES);
    }

    public String getLogs() {
        List<LogEntry> logEntries = BaseClass.webDriver.manage().logs().get(LogType.BROWSER).getAll();
        StringBuilder logs = new StringBuilder();
        for (LogEntry entry : logEntries) {
            System.out.println("Logs------->" + new Date(entry.getTimestamp()) + "-->" + entry.getLevel() + "-->" + entry.getMessage());
            logs.append(new Date(entry.getTimestamp()) + "-->" + entry.getLevel() + "-->" + entry.getMessage());
            logs.append(System.lineSeparator());
        }
        return logs.toString();
    }

    @Attachment(value = "Success/Failure Logs", type = "text/plain")
    public byte[] xLogs() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return getLogs().getBytes();
    }

    @Attachment(value = "Video of {0}", type = "video")
    public byte[] xVideos(String filename) {
        File file = new File("videos" + GlobalVar.slash + filename + ".mov");
        String path = file.getAbsolutePath();
        try {
            return Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}