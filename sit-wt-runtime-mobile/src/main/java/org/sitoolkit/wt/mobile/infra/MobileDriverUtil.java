package org.sitoolkit.wt.mobile.infra;

import java.net.URL;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class MobileDriverUtil {

    public static RemoteWebDriver getAndroidDriver(URL appiumAddress, DesiredCapabilities capabilities) {
        return new AndroidDriver<>(appiumAddress, capabilities);
    }

    public static RemoteWebDriver getIOSDriver(URL appiumAddress, DesiredCapabilities capabilities) {
        return new IOSDriver<>(appiumAddress, capabilities);
    }

    public static boolean checkAppiumDriverInstance(WebDriver driver) {
        return (driver instanceof AppiumDriver<?>);
    }

    public static boolean checkIOSDriverInstance(WebDriver driver) {
        return (driver instanceof IOSDriver<?>);
    }

    public static String getDriverContext(WebDriver driver) {
        AppiumDriver<?> appiumDriver = (AppiumDriver<?>) driver;
        return appiumDriver.getContext();
    }

    public static Set<String> getContextHandles(WebDriver driver) {
        AppiumDriver<?> appiumDriver = (AppiumDriver<?>) driver;
        return appiumDriver.getContextHandles();
    }

    public static void setContext(WebDriver driver, String context) {
        AppiumDriver<?> appiumDriver = (AppiumDriver<?>) driver;
        appiumDriver.getContextHandles();
        appiumDriver.context(context);
    }

    public static WebElement findElementByClassName(WebDriver driver, String className) {
        AppiumDriver<?> appiumDriver = (AppiumDriver<?>) driver;
        return appiumDriver.findElementByClassName(className);
    }

    public static WebElement findElementByTagName(WebDriver driver, String tagName) {
        AppiumDriver<?> appiumDriver = (AppiumDriver<?>) driver;
        return appiumDriver.findElementByTagName(tagName);
    }
}
