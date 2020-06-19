package com.giangtester.localhost;

import com.giangtester.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseLocalTest extends BaseTest {

    @BeforeEach
    public void prepare() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }
}
