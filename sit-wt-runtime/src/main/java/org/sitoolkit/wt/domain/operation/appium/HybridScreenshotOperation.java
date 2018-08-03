package org.sitoolkit.wt.domain.operation.appium;

import java.io.File;

import javax.annotation.Resource;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.sitoolkit.wt.domain.operation.ScreenshotOperation;
import org.sitoolkit.wt.infra.log.SitLogger;
import org.sitoolkit.wt.infra.log.SitLoggerFactory;
import org.sitoolkit.wt.mobile.infra.MobileDriverUtil;

public class HybridScreenshotOperation implements ScreenshotOperation {

    private static final String CONTEXT_NATIVE_APP = "NATIVE_APP";

    private static final SitLogger LOG = SitLoggerFactory
            .getLogger(HybridScreenshotOperation.class);

    @Resource
    WebDriver driver;

    @Override
    public File get() {
        if (driver instanceof TakesScreenshot) {

            String context = MobileDriverUtil.getDriverContext(driver);
            if (CONTEXT_NATIVE_APP.equals(context)) {
                context = null;
            } else {
                MobileDriverUtil.setContext(driver, CONTEXT_NATIVE_APP);
            }

            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            if (context != null) {
                MobileDriverUtil.setContext(driver, context);
            }

            return file;
        } else {
            LOG.warn("driver.screenshot.error", driver.getClass().getName());
            return null;
        }
    }

    @Override
    public File getWithDialog() {
        return get();
    }

}
