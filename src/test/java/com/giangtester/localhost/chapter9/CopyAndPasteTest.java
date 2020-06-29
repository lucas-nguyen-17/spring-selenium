package com.giangtester.localhost.chapter9;

import com.giangtester.localhost.chapter7.SeleniumRunner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.net.URI;

@SeleniumRunner
public class CopyAndPasteTest {


    @Qualifier("webDriver")
    @Autowired
    private WebDriver webDriver;

    @Autowired
    private URI baseUrl;

    @Test
    @Disabled
    void registration() {
        webDriver.get(baseUrl + "/registration-form.html");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) this.webDriver;
        String userAgent = (String) javascriptExecutor.executeScript("return navigator.userAgent");
        Keys modifier = userAgent.contains("Mac OS X") ? Keys.COMMAND : Keys.CONTROL;

        WebElement email = webDriver.findElement(By.name("email"));
        WebElement password = webDriver.findElement(By.name("password"));

        new Actions(webDriver)
                .sendKeys(email, "giang@email.com")
                .sendKeys(email, Keys.chord(modifier, "a", "c"))
                .sendKeys(password, Keys.chord(modifier, "v"))
                .perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
