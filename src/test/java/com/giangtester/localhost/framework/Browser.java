package com.giangtester.localhost.framework;

import org.openqa.selenium.WebDriver;

public class Browser extends DelegatingWebDriver implements FormElements{

    public Browser(WebDriver driver) {
        super(driver);
    }

}
