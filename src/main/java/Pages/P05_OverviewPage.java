package Pages;

import Utils.ElementAction.ElementActions;
import Utils.LogUtil.LogClass;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class P05_OverviewPage {

    //Variables
    AndroidDriver driver;

    //Constructor
    public P05_OverviewPage(AndroidDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By assertionText = AppiumBy.xpath("//android.widget.TextView[@text=\"CHECKOUT: OVERVIEW\"]");
    private final By finish_Btn = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]");

    //Methods
    @Step("Scroll down")
    public P05_OverviewPage scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int screenWidth = size.width;
        int screenHeight = size.height;

        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * 0.6);
        int width = screenWidth / 2;
        int height = screenHeight / 3;


        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", startX, "top", startY, "width", width, "height", height,
                "direction", "down",
                "percent", 0.8
        ));

        LogClass.info("scroll down", String.valueOf(canScrollMore));
        return this;
    }

    @Step("Click finish button")
    public P06_CompletePage clickFinishBtn() {
        ElementActions.clickOnElement(driver, finish_Btn);
        return new P06_CompletePage(driver);
    }


    //Validation
    @Step("Validate overview page title")
    public P05_OverviewPage validatePageTitle(String expectedText) {
        Assert.assertEquals(ElementActions.getText(driver, assertionText), expectedText);
        LogClass.info("overview page validated expected text:", expectedText);
        return this;
    }


}
