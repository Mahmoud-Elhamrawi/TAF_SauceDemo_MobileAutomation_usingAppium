package TestCases;

import Pages.P01_LoginPage;
import Utils.DataUtil.ReadPropertyFiles;
import Utils.LogUtil.LogClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.Assert;
import org.testng.annotations.*;
import Listeners.TestNGListeners;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
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
    AppiumDriverLocalService appiumServer;


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
                .scrollDown2()
                .clickFinishBtn()
                .validatePageTitle(getProperty("CHECKOUT_COMPLETE_TEXT"))
                .validateTextInElement(getProperty("THANK_YOU_ORDER"))
                .clickBackHomeBtn()
                .validatePageTitle(getProperty("product_Text"));
    }


    /// configuration
    @BeforeSuite
    public void beforeSuite() {

        appiumServer = new AppiumServiceBuilder()
                .withAppiumJS(new File(getProperty("main.js.path")))
                .withIPAddress(getProperty("ip.address"))
                .usingPort(Integer.parseInt(getProperty("port.number")))
                .build();

        if (!appiumServer.isRunning() || appiumServer == null) {
            Assert.assertNotNull(appiumServer);
            appiumServer.start();
        }

    }

    @BeforeClass
    public void beforeClass() throws URISyntaxException, MalformedURLException {
        options = new UiAutomator2Options();
        options.setDeviceName(getProperty("device.name"));
        options.setApp(getProperty("app.path"));
        options.setPlatformName(getProperty("app.platformName"));
        options.setAutomationName(getProperty("app.automationName"));
        options.setAppWaitActivity(getProperty("app.activity"));
        options.setAppWaitDuration(Duration.ofSeconds(30));

        driver = new AndroidDriver(new URI(getProperty("appium.url")).toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null)
            driver.quit();
    }

    @AfterSuite
    public void afterSuite() {
        appiumServer.stop();
    }


}
