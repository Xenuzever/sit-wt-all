package org.sitoolkit.wt.domain.operation.appium;

import javax.annotation.Resource;

import org.openqa.selenium.WebDriver;
import org.sitoolkit.wt.domain.operation.selenium.OpenOperation;
import org.sitoolkit.wt.domain.operation.selenium.SeleniumOperationContext;
import org.sitoolkit.wt.domain.testscript.TestStep;
import org.sitoolkit.wt.infra.Wrapper;
import org.springframework.stereotype.Component;

import io.appium.java_client.AppiumDriver;

@Component
public class StartAppOperation extends OpenOperation {

    @Resource
    Wrapper<WebDriver> seleniumDriverWrapper;

    @Override
    public void execute(TestStep testStep, SeleniumOperationContext ctx) {

        WebDriver seleniumDriver = seleniumDriverWrapper.get();

        if (seleniumDriver instanceof AppiumDriver<?>) {
            AppiumDriver<?> appiumDriver = (AppiumDriver<?>) seleniumDriver;
            for (String contextHandle : appiumDriver.getContextHandles()) {
                if (contextHandle.startsWith("WEBVIEW")) {
                    appiumDriver.context(contextHandle);
                }
            }
        } else {
            super.execute(testStep, ctx);
        }
    }
}
