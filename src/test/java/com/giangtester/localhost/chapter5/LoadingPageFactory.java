package com.giangtester.localhost.chapter5;

import com.giangtester.localhost.chapter7.LoadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LoadingPageFactory {

    private static LoadConfig config;

    @Autowired
    private LoadConfig loadConfig;

    @PostConstruct
    private void init() {
        config = this.loadConfig;
    }

    public static <T> T get(WebDriver driver, Class<T> pageObjectClass) {
        verifyTitle(driver, pageObjectClass);
        return PageFactory.initElements(driver, pageObjectClass);
    }

    public static <T> T openPage(WebDriver driver, Class<T> pageObjectClass) {
        driver.get(linkToPage(pageObjectClass));
        return get(driver, pageObjectClass);
    }

    private static <T> void verifyTitle(WebDriver driver, Class<T> pageObjectClass) {
        String expectedTitle = pageObjectClass.getAnnotation(Verify.class).title();
        if (!expectedTitle.equals(Verify.INVALID_TITLE)) {
            String actualTitle = driver.getTitle();
            if (!actualTitle.contains(expectedTitle)) {
                throw new IllegalStateException(
                        String.format("expected page title contains '%s' but it was '%s'", expectedTitle, actualTitle)
                );
            }
        }
    }

    private static <T> String linkToPage(Class<T> pageObjectClass) {
        return config.getBaseUrl() + pageObjectClass.getAnnotation(Path.class).value();
    }
}
