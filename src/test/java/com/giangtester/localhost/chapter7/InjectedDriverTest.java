package com.giangtester.localhost.chapter7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.net.URI;

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(WebDriverConfig.class)
@TestExecutionListeners(listeners = {ScreenshotTaker.class, DependencyInjectionTestExecutionListener.class})
public class InjectedDriverTest {

    @Autowired
    private WebDriver driver;

    @Autowired
    private URI baseURL;

    @Test
    void openPage() {
        driver.get("https://www.google.com/");
    }

    @Test
    @DirtiesContext
    void openPage1() {
        driver.get(baseURL + "/popups.html");
        driver.findElement(By.id("alert")).click();
        driver.switchTo().alert().accept();
    }

    @Test
    void openPage2() {
        driver.get(baseURL + "/");
    }
}
