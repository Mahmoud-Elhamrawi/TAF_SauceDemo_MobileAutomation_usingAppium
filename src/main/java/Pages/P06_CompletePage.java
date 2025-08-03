package Pages;

import Utils.ElementAction.ElementActions;
import Utils.LogUtil.LogClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class P06_CompletePage {

    //Variables
    AndroidDriver driver;

    //Constructor
    public P06_CompletePage(AndroidDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By completePage_text = AppiumBy.xpath("//android.widget.TextView[@text=\"CHECKOUT: COMPLETE!\"]");
    private final By thankYou_text = AppiumBy.xpath("//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]");
    private final By backHome_Btn = AppiumBy.accessibilityId("test-BACK HOME");


    //Methods
    @Step("Click back home button")
    public P02_HomePage clickBackHomeBtn() {
        ElementActions.clickOnElement(driver, backHome_Btn);
        LogClass.info("clicked back home button");
        return new P02_HomePage(driver);
    }

    //Validation
    @Step("Validate complete page title")
    public P06_CompletePage validatePageTitle(String expectedText) {
        Assert.assertEquals(ElementActions.getText(driver, completePage_text), expectedText);
        LogClass.info("complete page validated expected text:", expectedText);
        return this;
    }

    @Step("Validate text in element")
    public P06_CompletePage validateTextInElement(String expectedText) {
        Assert.assertEquals(ElementActions.getText(driver, thankYou_text), expectedText);
        LogClass.info("complete page validated expected text:", expectedText);
        return this;
    }


}
