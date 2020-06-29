package com.giangtester.localhost.framework;

import com.giangtester.localhost.chapter7.SeleniumRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@SeleniumRunner
public class DemoFW {

    @Autowired
    private WebDriver driver;

    @Test
    void getRelativeBaseUrl() {
        driver.get("/hello-webdriver.html");
    }
}
