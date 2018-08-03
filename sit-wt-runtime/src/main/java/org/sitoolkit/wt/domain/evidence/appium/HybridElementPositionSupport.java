package org.sitoolkit.wt.domain.evidence.appium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.sitoolkit.wt.domain.evidence.ElementPosition;
import org.sitoolkit.wt.domain.evidence.selenium.ElementPositionSupport;
import org.sitoolkit.wt.mobile.infra.MobileDriverUtil;

public class HybridElementPositionSupport extends ElementPositionSupport {

    private Point basePos;

    private double scale;

    private boolean initialized;

    @Override
    public ElementPosition get(WebElement element) {
        if (!initialized) {
            String context = MobileDriverUtil.getDriverContext(driver);

            MobileDriverUtil.setContext(driver, "NATIVE_APP");

            WebElement baseElement = MobileDriverUtil.findElementByClassName(driver,
                    "android.webkit.WebView");
            basePos = baseElement.getLocation();
            Dimension dim = baseElement.getSize();

            MobileDriverUtil.setContext(driver, context);

            WebElement htmlElement = MobileDriverUtil.findElementByTagName(driver, "body");

            scale = (double) dim.getWidth() / htmlElement.getSize().getWidth();

            initialized = true;
            log.debug("座標を初期化しました 基準座標:{}, 縮尺:{}", basePos, scale);
        }

        Point elementPos = element.getLocation();
        log.debug("要素:{}, 要素位置:{}", element, elementPos);

        return new ElementPosition(elementPos.getX() * scale + basePos.getX(),
                elementPos.getY() * scale + basePos.getY(), element.getSize().getWidth() * scale,
                element.getSize().getHeight() * scale);
    }

}
