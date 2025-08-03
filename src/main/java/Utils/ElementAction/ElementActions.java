package Utils.ElementAction;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ElementActions {


    // click on ele
    public static void clickOnElement(AndroidDriver driver, By locator) {
        driver.findElement(locator).click();
    }

    // send text
    public static void sendText(AndroidDriver driver, By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    // get text
    public static String getText(AndroidDriver driver, By locator) {
        return driver.findElement(locator).getText();
    }

}
