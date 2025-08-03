package Pages;

import Utils.ElementAction.ElementActions;
import Utils.LogUtil.LogClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P01_LoginPage {
    //Variables
    AndroidDriver driver;


    //Constructor
    public P01_LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By username_Inp = AppiumBy.accessibilityId("test-Username");
    private final By password_Inp = AppiumBy.accessibilityId("test-Password");
    private final By login_Btn = AppiumBy.accessibilityId("test-LOGIN");


    //method actions
    @Step("Enter Username")
    public P01_LoginPage enterUserName(String username) {
        ElementActions.sendText(driver, username_Inp, username);
        LogClass.info("username entered:", username);
        return this;
    }

    @Step("Enter Password")
    public P01_LoginPage enterPassword(String password) {
        ElementActions.sendText(driver, password_Inp, password);
        LogClass.info("password entered:", password);
        return this;
    }

    @Step("Click Login Button")
    public P02_HomePage clickLoginBtn() {
        ElementActions.clickOnElement(driver, login_Btn);
        LogClass.info("login button clicked");
        return new P02_HomePage(driver);
    }


}
