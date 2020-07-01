package com.giangtester.localhost.chapter9;

import com.giangtester.localhost.chapter7.SeleniumRunner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SeleniumRunner
public class ActionChains {


    @Qualifier("webDriver")
    @Autowired
    private WebDriver driver;

    @Autowired
    private URI baseUrl;

    @Test
    public void staleElementProblem() {
        driver.get(baseUrl + "/stale-elements.html");
        WebElement button = driver.findElement(By.id("button"));
        new Actions(driver)
                .click(button)
                .click(button)
                .perform();
    }

    @Test
    @Disabled
    public void lazyActionChain(){

        driver.get(baseUrl + "/stale-elements.html");
        WebElement button = driver.findElement(By.id("button"));

        WebElement customButton = new LazyElement(button);

        new Actions(driver)
                .click(customButton)
                .click(customButton)
                .perform();

        assertEquals("Click This Button", button.getText());
    }
}
