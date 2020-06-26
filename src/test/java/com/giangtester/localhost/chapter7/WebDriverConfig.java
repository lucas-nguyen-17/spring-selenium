package com.giangtester.localhost.chapter7;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.URI;
import java.net.URL;

@Configuration
@ComponentScan("com.giangtester")
@PropertySource("classpath:application.properties")
public class WebDriverConfig {

    @Autowired
    private WebDriverCleaner webDriverCleaner;

    @Autowired
    private LoadConfig config;

    @Bean
    public URI getBaseUrl() {
        return config.getBaseUrl();
    }

    @Bean
    public DesiredCapabilities desiredCapabilities(
            @Value("${browser}") String browserName) {
        return new DesiredCapabilities(browserName, "", Platform.ANY);
    }

    @Bean
    public WebDriverFactory webDriverFactory(
            @Value("${webdriver.remote:false}") boolean isRemoteDriver,
            @Value("${webdriver.remote.url:http://localhost:4444/wd/hub}") URL remoteUrl
    ) {
        return new WebDriverFactory(isRemoteDriver, remoteUrl);
    }

    @Bean(destroyMethod = "quit")
    @Lazy
    public WebDriver dirtyWebDriver(WebDriverFactory webDriverFactory,
                                    DesiredCapabilities desiredCapabilities,
                                    URI baseUrl) {
        return webDriverFactory.webDriver(desiredCapabilities, baseUrl);
    }

    @Bean
    @Primary
    @Scope("prototype")
    public WebDriver webDriver(@Qualifier("dirtyWebDriver") WebDriver driver) {
        return webDriverCleaner.cleanWebDriver(driver);
    }

    @Bean
    @Primary
    public ConfigurableEnvironment environment() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LoadConfig.class);
        return context.getEnvironment();
    }

    @Bean
    @Scope("singleton")
    public LoadConfig loadConfig() {
        return new LoadConfig();
    }

}
