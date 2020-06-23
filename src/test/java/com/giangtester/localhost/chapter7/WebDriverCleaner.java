package com.giangtester.localhost.chapter7;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class WebDriverCleaner {

    WebDriver cleanWebDriver(WebDriver driver) {
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(0, TimeUnit.SECONDS);
        closeRedundantWindows(driver);
        return driver;
    }

    private void closeRedundantWindows(WebDriver driver) {
        Set<String> windowHandles = driver.getWindowHandles();
        if (windowHandles.size() > 1) {

            driver.switchTo().defaultContent();

            String topWindowHandle = driver.getWindowHandle();

            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(topWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    driver.close();
                }
            }
        }
    }
}
