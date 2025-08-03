package Pages;

import Utils.ElementAction.ElementActions;
import Utils.LogUtil.LogClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class P03_CartPage {

    //Variables
    AndroidDriver driver;

    //Constructor
    public P03_CartPage(AndroidDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By cartPage_text = AppiumBy.xpath("//android.widget.TextView[@text=\"YOUR CART\"]");
    private final By checkout_Btn = AppiumBy.accessibilityId("test-CHECKOUT");


    //Methods
    @Step("Click on checkout button")
    public P04_CheckoutPage clickCheckoutBtn() {
        ElementActions.clickOnElement(driver, checkout_Btn);
        return new P04_CheckoutPage(driver);
    }

    //Validation
    @Step("Validate cart page title")
    public P03_CartPage validatePageTitle(String expectedText) {
        Assert.assertEquals(ElementActions.getText(driver, cartPage_text), expectedText);
        LogClass.info("cart page validated expected text:", expectedText);
        return this;
    }


}
