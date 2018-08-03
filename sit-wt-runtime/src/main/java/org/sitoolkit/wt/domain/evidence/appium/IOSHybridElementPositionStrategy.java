package org.sitoolkit.wt.domain.evidence.appium;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sitoolkit.wt.domain.evidence.ElementPositionStrategy;
import org.sitoolkit.wt.domain.evidence.selenium.ElementPositionSupport2;
import org.sitoolkit.wt.mobile.infra.MobileDriverUtil;

public class IOSHybridElementPositionStrategy implements ElementPositionStrategy {

    @SuppressWarnings("unchecked")
    @Override
    public void init(ElementPositionSupport2 eps, WebDriver driver) {

        String context = MobileDriverUtil.getDriverContext(driver);

        MobileDriverUtil.setContext(driver, "NATIVE_APP");
        WebElement baseElement = MobileDriverUtil.findElementByClassName(driver, "UIAWebView");
        eps.setBasePosition(baseElement.getLocation());

        MobileDriverUtil.setContext(driver, context);

    }

    @Override
    public Point getCurrentBasePosition(WebDriver driver, WebElement currentFrame) {
        return new Point(0, 0);
    }

}
