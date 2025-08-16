package Utils.UtilClasses;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {

    //scroll to element
    public static WebElement scrollToEle(WebDriver driver , String txt)
    {
        return driver.findElement(AppiumBy.androidUIAutomator(String.format(
                "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"%s\"));",txt
        )));


    }





}
