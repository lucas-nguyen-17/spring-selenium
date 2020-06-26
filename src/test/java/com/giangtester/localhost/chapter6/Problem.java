package com.giangtester.localhost.chapter6;

import com.giangtester.localhost.chapter7.LoadConfig;
import com.giangtester.localhost.chapter7.SeleniumRunner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Locale;
import java.util.ResourceBundle;

@SeleniumRunner
@Slf4j
public class Problem {


    @Qualifier("webDriver")
    @Autowired
    private WebDriver driver;

    @Autowired
    private LoadConfig loadConfig;

    @Test()
    void cannotFindElement() {
        driver.get("http://localhost:8080/react-datepicker.html");
//        driver.findElement(By.cssSelector(".ignore-react-onclickoutside"));
        driver.findElement(By.tagName("input"));

        /*try {
            driver.get("http://localhost:8080/react-datepicker.html");
            driver.findElement(By.cssSelector(".ignore-react-onclickoutside"));
        } catch (NoSuchElementException e) {
            log.info("NoSuchElementException");
        }*/
    }

    @Test
    void resourceBundleExample() {
        String language = Locale.getDefault().getLanguage();
        driver.get(loadConfig.getBaseUrl() + "/" + language + "/login.html");
        ResourceBundle strings = ResourceBundle.getBundle("strings");
        log.info(strings.getString("forgotten.password"));
    }
}
