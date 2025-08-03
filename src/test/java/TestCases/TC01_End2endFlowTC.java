package TestCases;

import Pages.P01_LoginPage;
import Utils.LogUtil.LogClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.Assert;
import org.testng.annotations.*;
import Listeners.TestNGListeners;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

import static Utils.DataUtil.ReadJsonFile.getJsonData;
import static Utils.DataUtil.ReadPropertyFiles.getProperty;

@Listeners(TestNGListeners.class)
public class TC01_End2endFlowTC {

    AndroidDriver driver;
    UiAutomator2Options options;
    AppiumDriverLocalService appiumService;
    AppiumServiceBuilder builder;


    @Test
    public void end2EndFlow() {

        new P01_LoginPage(driver)
                .enterUserName(getJsonData("valid_Credential_Data.username"))
                .enterPassword(getJsonData("valid_Credential_Data.password"))
                .clickLoginBtn()
                .validatePageTitle(getProperty("product_Text"))
                .clickAddToCartBtn()
                .clickCartIconBtn()
                .validatePageTitle(getProperty("cart_Text"))
                .clickCheckoutBtn()
                .validatePageTitle(getProperty("CHECKOUT_INFORMATION_TEXT"))
                .enterFirstName(getJsonData("userInfo_Data.firstname"))
                .enterLastName(getJsonData("userInfo_Data.lastname"))
                .enterPostalCode(getJsonData("userInfo_Data.zipcode"))
                .clickContinueBtn()
                .validatePageTitle(getProperty("CHECKOUT_OVERVIEW_TEXT"))
                .scrollDown()
                .clickFinishBtn()
                .validatePageTitle(getProperty("CHECKOUT_COMPLETE_TEXT"))
                .validateTextInElement(getProperty("THANK_YOU_ORDER"))
                .clickBackHomeBtn()
                .validatePageTitle(getProperty("product_Text"));
    }

    /// configuration
    @BeforeSuite
    public void beforeSuite() {

        builder = new AppiumServiceBuilder()
                .withAppiumJS(new File(Objects.requireNonNull(getProperty("main.js.path"))))
                .withIPAddress(getProperty("ip.address"))
                .usingPort(Integer.parseInt(Objects.requireNonNull(getProperty("port.number"))));

        appiumService = AppiumDriverLocalService.buildService(builder);

        if (appiumService != null && appiumService.isRunning())
            LogClass.info("appium service is running");
        else {
            Assert.assertNotNull(appiumService);
            appiumService.start();
        }


    }


    @BeforeClass
    public void beforeClass()  {
        options = new UiAutomator2Options();
        options.setDeviceName(getProperty("device.name"));
        options.setApp(getProperty("app.path"));
        options.setPlatformName(getProperty("app.platformName"));
        options.setAutomationName(getProperty("app.automationName"));
        options.setAppWaitActivity(getProperty("app.activity"));
        options.setAppWaitDuration(Duration.ofSeconds(30));

    }


    @BeforeMethod
    public void beforeMethod() throws MalformedURLException, URISyntaxException {
        driver = new AndroidDriver(new URL(Objects.requireNonNull(getProperty("appium.url"))).toURI().toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null)
            driver.quit();
    }

    @AfterSuite
    public void afterSuite() {
        appiumService.stop();
    }


}
