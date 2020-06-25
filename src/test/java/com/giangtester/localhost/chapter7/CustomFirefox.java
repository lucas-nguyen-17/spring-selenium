package com.giangtester.localhost.chapter7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CustomFirefox {

    public static WebDriver create() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--width=1600");
        options.addArguments("--height=900");
        options.addArguments("-private");
        options.addPreference("network.automatic-ntlm-auth.trusted-uris", "http://,https://");
        options.addPreference("network.automatic-ntlm-auth.allow-non-fqdn", true);
        options.addPreference("network.negotiate-auth.delegation-uris", "http://,https://");
        options.addPreference("network.negotiate-auth.trusted-uris", "http://,https://");
        options.addPreference("network.http.phishy-userpass-length", 255);
        options.addPreference("security.csp.enable", false);
        options.addPreference("network.proxy.no_proxies_on", "");
        return new FirefoxDriver(options);
    }
}
