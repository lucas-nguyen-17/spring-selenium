package com.giangtester.localhost.chapter7;

import com.giangtester.localhost.framework.BaseUrlDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.net.URL;

public class WebDriverFactory {

    private final boolean isRemoteDriver;
    private final URL remoteUrl;

    public WebDriverFactory(boolean isRemoteDriver, URL remoteUrl) {
        this.isRemoteDriver = isRemoteDriver;
        this.remoteUrl = remoteUrl;
    }

    WebDriver webDriver(DesiredCapabilities desiredCapabilities, URI baseUrl) {
        WebDriver baseDriver = isRemoteDriver ?
                remoteDriver(remoteUrl, desiredCapabilities) :
                localDriver(desiredCapabilities);
        return new BaseUrlDriver(baseDriver, baseUrl);
    }

    private WebDriver remoteDriver(URL remoteUrl, DesiredCapabilities desiredCapabilities) {
        return new Augmenter().augment(new RemoteWebDriver(remoteUrl, desiredCapabilities));
    }

    private WebDriver localDriver(DesiredCapabilities desiredCapabilities) {
        switch (desiredCapabilities.getBrowserName()) {
            case BrowserType.FIREFOX:
                return CustomFirefox.create();
            case BrowserType.CHROME:
                return CustomChrome.create();
            default:
                throw new IllegalStateException("unknown browser");
        }
    }

}
