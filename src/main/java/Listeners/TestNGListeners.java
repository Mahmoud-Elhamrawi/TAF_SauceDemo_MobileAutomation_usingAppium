package Listeners;

import Utils.DataUtil.ReadJsonFile;
import Utils.LogUtil.LogClass;
import org.testng.*;

import java.io.File;

import static Utils.DataUtil.ReadPropertyFiles.loadPropertyFile;
import static Utils.FileUtils.FileClass.cleanFolder;

public class TestNGListeners implements IExecutionListener, IInvokedMethodListener, ITestListener {

    File allureFolder = new File("test-outputs/target/allure-results/");
    File logFolder = new File("test-outputs/logs/");

    @Override
    public void onExecutionStart() {
        LogClass.info("Execution started");
        loadPropertyFile();
        new ReadJsonFile("userData");


        cleanFolder(allureFolder)  ;
        LogClass.info("previous allure folder cleaned");

        cleanFolder(logFolder);
        LogClass.info("previous log folder cleaned");



    }

    @Override
    public void onExecutionFinish() {
        LogClass.info("Execution finished");
    }

    @Override

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // not implemented
    }


    @Override

    public void onTestStart(ITestResult result) {
        LogClass.info("Test Case", result.getName(), "Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogClass.info("Test Case", result.getName(), "Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogClass.info("Test Case", result.getName(), "Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogClass.info("Test Case", result.getName(), "Skipped");
    }


    @Override
    public void onStart(ITestContext context) {
        LogClass.info("Test Suite", context.getName(), "Started");
    }

    @Override
    public void onFinish(ITestContext context) {
        LogClass.info("Test Suite", context.getName(), "Finished");
    }


}
