package Pages;

import Utils.ElementAction.ElementActions;
import Utils.LogUtil.LogClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class P04_CheckoutPage {

    //Variables
    AndroidDriver driver;

    //Constructor
    public P04_CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By checkoutPage_text = AppiumBy.xpath("//android.widget.TextView[@text=\"CHECKOUT: INFORMATION\"]");
    private final By firstName_Inp = AppiumBy.accessibilityId("test-First Name");
    private final By lastName_Inp = AppiumBy.accessibilityId("test-Last Name");
    private final By postalCode_Inp = AppiumBy.accessibilityId("test-Zip/Postal Code");
    private final By continue_Btn = AppiumBy.accessibilityId("test-CONTINUE");

    // method
    @Step("enter first name")
    public P04_CheckoutPage enterFirstName(String firstName) {
        ElementActions.sendText(driver, firstName_Inp, firstName);
        return this;
    }

    @Step("enter last name")
    public P04_CheckoutPage enterLastName(String lastName) {
        ElementActions.sendText(driver, lastName_Inp, lastName);
        return this;
    }

    @Step("enter postal code")
    public P04_CheckoutPage enterPostalCode(String postalCode) {
        ElementActions.sendText(driver, postalCode_Inp, postalCode);
        return this;
    }

    @Step("click continue button")
    public P05_OverviewPage clickContinueBtn() {
        ElementActions.clickOnElement(driver, continue_Btn);
        return new P05_OverviewPage(driver);
    }


    // validation
    @Step("validate checkout page title")
    public P04_CheckoutPage validatePageTitle(String expectedText) {
        Assert.assertEquals(ElementActions.getText(driver, checkoutPage_text), expectedText);
        LogClass.info("checkout page validated expected text:", expectedText);
        return this;
    }

}
