package Pages;

import Utils.ElementAction.ElementActions;
import Utils.LogUtil.LogClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class P02_HomePage {
    AndroidDriver driver;

    //constructor
    public P02_HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By HomePageText_txt = AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
    private final By addToCart_Btn = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]");
    private final By cartIcon_Btn = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup");


    //Methods
    @Step("click add to cart button")
    public P02_HomePage clickAddToCartBtn() {
        ElementActions.clickOnElement(driver, addToCart_Btn);
        return this;
    }

    @Step("click cart icon")
    public P03_CartPage clickCartIconBtn() {
        ElementActions.clickOnElement(driver, cartIcon_Btn);
        return new P03_CartPage(driver);
    }


    //validation
    @Step("validate home page title")
    public P02_HomePage validatePageTitle(String expectedText) {
        Assert.assertEquals(ElementActions.getText(driver, HomePageText_txt), expectedText);

        LogClass.info("home page validated expected text:", expectedText);
        return this;
    }

}
