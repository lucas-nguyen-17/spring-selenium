package com.giangtester.localhost.framework;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class BaseUrlDriver extends DelegatingWebDriver {

    @Autowired
    private final URI baseUrl;

    public BaseUrlDriver(WebDriver driver, URI baseUrl) {
        super(driver);
        this.baseUrl = baseUrl;
    }

    @Override
    public void get(String url) {
        super.get(!url.contains("://") ? baseUrl + url : url);
    }
}
