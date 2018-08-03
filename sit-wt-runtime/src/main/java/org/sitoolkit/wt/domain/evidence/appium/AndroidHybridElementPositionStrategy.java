package org.sitoolkit.wt.domain.evidence.appium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sitoolkit.wt.domain.evidence.ElementPositionStrategy;
import org.sitoolkit.wt.domain.evidence.selenium.ElementPositionSupport2;
import org.sitoolkit.wt.mobile.infra.MobileDriverUtil;

public class AndroidHybridElementPositionStrategy implements ElementPositionStrategy {

    @Override
    public void init(ElementPositionSupport2 eps, WebDriver driver) {
        String context = MobileDriverUtil.getDriverContext(driver);

        // BasePosition
        MobileDriverUtil.setContext(driver, "NATIVE_APP");
        WebElement baseElement = MobileDriverUtil.findElementByClassName(driver,
                "android.webkit.WebView");
        eps.setBasePosition(baseElement.getLocation());
        Dimension dim = baseElement.getSize();
        MobileDriverUtil.setContext(driver, context);

        // Scale
        WebElement htmlElement = MobileDriverUtil.findElementByTagName(driver, "body");
        double scale = (double) dim.getWidth() / htmlElement.getSize().getWidth();
        eps.setScale(scale);

    }

    @Override
    public Point getCurrentBasePosition(WebDriver driver, WebElement currentFrame) {
        return new Point(0, 0);
    }

}
