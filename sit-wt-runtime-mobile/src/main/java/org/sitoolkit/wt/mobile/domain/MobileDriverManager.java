package org.sitoolkit.wt.mobile.domain;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class MobileDriverManager {

    public RemoteWebDriver getAndroidDriver(URL appiumAddress, DesiredCapabilities capabilities) {
        return new AndroidDriver<>(appiumAddress, capabilities);
    }

    public RemoteWebDriver getIOSDriver(URL appiumAddress, DesiredCapabilities capabilities) {
        return new IOSDriver<>(appiumAddress, capabilities);
    }

}
