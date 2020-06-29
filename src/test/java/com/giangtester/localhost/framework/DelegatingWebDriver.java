package com.giangtester.localhost.framework;

import org.openqa.selenium.*;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class DelegatingWebDriver implements WebDriver, JavascriptExecutor, TakesScreenshot,
        HasCapabilities, WrapsDriver, ExplicitWait {

    private final WebDriver delegateDriver;

    public DelegatingWebDriver(WebDriver driver) {
        this.delegateDriver = driver;
    }

    @Override
    public void get(String url) {
        delegateDriver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return delegateDriver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return delegateDriver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return delegateDriver.findElements(by);
    }

    @Override
    public Element findElement(By by) {
        return new Element(delegateDriver.findElement(by));
    }

    @Override
    public Element findElement(Supplier<By> by) {
        return new Element(delegateDriver.findElement(by.get()));
    }

    @Override
    public String getPageSource() {
        return delegateDriver.getPageSource();
    }

    @Override
    public void close() {
        delegateDriver.close();
    }

    @Override
    public void quit() {
        delegateDriver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return delegateDriver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return delegateDriver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return delegateDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return delegateDriver.navigate();
    }

    @Override
    public Options manage() {
        return delegateDriver.manage();
    }

    @Override
    public Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) delegateDriver).executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        return ((JavascriptExecutor) delegateDriver).executeAsyncScript(script, args);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return ((TakesScreenshot) delegateDriver).getScreenshotAs(target);
    }

    @Override
    public Capabilities getCapabilities() {
        return ((HasCapabilities) delegateDriver).getCapabilities();
    }

    @Override
    public WebDriver getWrappedDriver() {
        return ((WrapsDriver) delegateDriver).getWrappedDriver();
    }

}
