package TestCases;

import Pages.P01_LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;
import Listeners.TestNGListeners;

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


    @BeforeMethod
    public void beforeMethod() throws MalformedURLException, URISyntaxException {

        options = new UiAutomator2Options();
        options.setDeviceName(getProperty("device.name"));
        options.setApp(getProperty("app.path"));
        options.setAppWaitActivity("com.swaglabsmobileapp.*");
        options.setAppWaitDuration(Duration.ofSeconds(30));


        driver = new AndroidDriver(new URL(Objects.requireNonNull(getProperty("appium.url"))).toURI().toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

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


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


}
