package com.giangtester.localhost.framework;

import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrowserConfig {

    @Bean
    public Browser browser(WebDriver driver) {
        return new Browser(driver);
    }
}
