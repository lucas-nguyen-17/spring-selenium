package com.giangtester.localhost.chapter7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        return isRemoteDriver ?
                remoteDriver(remoteUrl, desiredCapabilities) :
                localDriver(desiredCapabilities);
    }

    private WebDriver remoteDriver(URL remoteUrl, DesiredCapabilities desiredCapabilities) {
        return new Augmenter().augment(new RemoteWebDriver(remoteUrl, desiredCapabilities));
    }

    private WebDriver localDriver(DesiredCapabilities desiredCapabilities) {
        switch (desiredCapabilities.getBrowserName()) {
            case BrowserType.FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case BrowserType.CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                return new ChromeDriver(options);
            default:
                throw new IllegalStateException("unknown browser");
        }
    }

}
