package org.sitoolkit.wt.domain.evidence.appium;

import javax.annotation.Resource;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.sitoolkit.wt.domain.evidence.ScreenshotTaker;
import org.sitoolkit.wt.mobile.infra.MobileDriverUtil;

public class HybridScreenshotTaker extends ScreenshotTaker {

    private static final String CONTEXT_NATIVE_APP = "NATIVE_APP";

    @Resource
    WebDriver driver;

    @Resource
    TakesScreenshot takesScreenshot;

    @Override
    public String getAsData() {
        String context = MobileDriverUtil.getDriverContext(driver);
        if (CONTEXT_NATIVE_APP.equals(context)) {
            context = null;
        } else {
            MobileDriverUtil.setContext(driver, CONTEXT_NATIVE_APP);
        }

        String data = takesScreenshot.getScreenshotAs(OutputType.BASE64);

        if (context != null) {
            MobileDriverUtil.setContext(driver, context);
        }

        return data;
    }

    @Override
    public String getDialogAsData() {
        return getAsData();
    }

}
