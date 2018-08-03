package org.sitoolkit.wt.domain.evidence.selenium;

import org.openqa.selenium.WebDriver;
import org.sitoolkit.wt.domain.evidence.ElementPositionStrategy;
import org.sitoolkit.wt.domain.evidence.appium.AndroidHybridElementPositionStrategy;
import org.sitoolkit.wt.domain.evidence.appium.IOSHybridElementPositionStrategy;
import org.sitoolkit.wt.domain.evidence.appium.MobileNativeElementPositionStartegy;
import org.sitoolkit.wt.mobile.infra.MobileDriverUtil;

public class ElementPositionSupportFactory {

    public static ElementPositionStrategy getStrategy(WebDriver driver) {

        if (MobileDriverUtil.checkAppiumDriverInstance(driver)) {

            if (MobileDriverUtil.getDriverContext(driver).startsWith("WEBVIEW")) {

                if (MobileDriverUtil.checkIOSDriverInstance(driver)) {
                    return new IOSHybridElementPositionStrategy();
                } else {
                    return new AndroidHybridElementPositionStrategy();
                }

            } else {
                return new MobileNativeElementPositionStartegy();
            }

        } else {
            return new PcBrowserElementPositionStrategy();
        }

    }
}
