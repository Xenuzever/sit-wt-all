package org.sitoolkit.wt.domain.evidence.appium;

import org.openqa.selenium.Point;
import org.sitoolkit.wt.domain.evidence.selenium.ElementPositionSupport;

public class NativeElementPositionSupport extends ElementPositionSupport {

    @Override
    protected Point getCurrentBasePosition() {
        return new Point(0, 0);
    }
}
