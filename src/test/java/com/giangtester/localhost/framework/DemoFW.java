package com.giangtester.localhost.framework;

import com.giangtester.localhost.chapter7.SeleniumRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

import static com.giangtester.localhost.framework.locators.CssSelector.TOOLS_LOCATION_STRONG;
import static com.giangtester.localhost.framework.locators.Id.LOCATION;
import static com.giangtester.localhost.framework.locators.LinkText.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.linkText;

@SeleniumRunner
public class DemoFW {

    @Autowired
    private WebDriver driver;

    private Browser browser;

    @Autowired
    private void setWebDriver(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    @Test
    void getRelativeBaseUrl() {
        driver.get("/hello-webdriver.html");
    }

    @Test
    void usingExplicitWaitInterface() {
        browser.get("/location-chooser.html");
        browser.await(CHOOSE_LOCATION).click();
        Element tabMenu = new Element(browser.findElement(LOCATION));
        tabMenu.await(MEXICO).click();
        tabMenu.await(CANCUN).click();
        assertEquals("Cancun", browser.await(TOOLS_LOCATION_STRONG).getText());
    }

    @Test
    void chooseLocation() {
        driver.get("/location-chooser.html");
        driver.findElement(linkText("choose location")).click();
        WebElement tabMenu = driver.findElement(By.id("location"));
        tabMenu.findElement(linkText("MEXICO")).click();
        tabMenu.findElement(linkText("Cancun")).click();
        assertEquals(0, tabMenu.findElements(linkText("Cancun")).size());
        assertEquals("Cancun", driver
                .findElement(By.cssSelector(".tools-location strong"))
                .getText());
    }

    @Test
    public void usingImplicitWait() {
        driver.manage().timeouts().implicitlyWait(5, SECONDS); // <1>
        driver.get("/location-chooser.html");
        driver.findElement(linkText("choose location")).click();
        WebElement tabMenu = driver.findElement(By.id("location"));
        tabMenu.findElement(linkText("MEXICO")).click();
        tabMenu.findElement(linkText("Cancun")).click();
        assertEquals(0, tabMenu.findElements(linkText("Cancun")).size());
        assertEquals("Cancun", driver
                .findElement(By.cssSelector(".tools-location strong"))
                .getText());
        driver.manage().timeouts().implicitlyWait(0, SECONDS); // <1>
    }

    @Test
    public void usingExplicitWaitLambda() {
        driver.get("/location-chooser.html");
        driver.findElement(linkText("choose location")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5); // <1>

        WebElement tabMenu = webDriverWait
                .until((WebDriver d) -> driver.findElement(By.id("location")));

        FluentWait<WebElement> webElementWait = new FluentWait<>(tabMenu)
                .withTimeout(Duration.ofMillis(5000))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class);

        webElementWait.until(element -> tabMenu.findElement(linkText("MEXICO"))).click();
        webElementWait.until(element -> tabMenu.findElement(linkText("Cancun"))).click();
        assertEquals(0, tabMenu.findElements(linkText("Cancun")).size());
        assertEquals("Cancun", driver
                .findElement(By.cssSelector(".tools-location strong"))
                .getText());
    }
}
