package org.sitoolkit.wt.domain.operation.appium;

import org.sitoolkit.wt.domain.operation.selenium.OpenOperation;
import org.sitoolkit.wt.domain.operation.selenium.SeleniumOperationContext;
import org.sitoolkit.wt.domain.testscript.TestStep;
import org.sitoolkit.wt.mobile.infra.MobileDriverUtil;
import org.springframework.stereotype.Component;

@Component
public class StartAppOperation extends OpenOperation {

    @Override
    public void execute(TestStep testStep, SeleniumOperationContext ctx) {

        if (MobileDriverUtil.checkAppiumDriverInstance(seleniumDriver)) {
            for (String contextHandle : MobileDriverUtil.getContextHandles(seleniumDriver)) {
                if (contextHandle.startsWith("WEBVIEW")) {
                    MobileDriverUtil.setContext(seleniumDriver, contextHandle);
                }
            }
        } else {
            super.execute(testStep, ctx);
        }
    }
}
