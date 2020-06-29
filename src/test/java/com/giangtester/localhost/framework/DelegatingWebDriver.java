package com.giangtester.localhost.framework;

import org.openqa.selenium.*;

import java.util.List;
import java.util.Set;

public class DelegatingWebDriver implements WebDriver, JavascriptExecutor, TakesScreenshot,
        HasCapabilities, WrapsDriver {

    private final WebDriver delegate;

    public DelegatingWebDriver(WebDriver driver) {
        this.delegate = driver;
    }

    @Override
    public void get(String url) {
        delegate.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return delegate.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return delegate.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return delegate.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return delegate.findElement(by);
    }

    @Override
    public String getPageSource() {
        return delegate.getPageSource();
    }

    @Override
    public void close() {
        delegate.close();
    }

    @Override
    public void quit() {
        delegate.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return delegate.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return delegate.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return delegate.switchTo();
    }

    @Override
    public Navigation navigate() {
        return delegate.navigate();
    }

    @Override
    public Options manage() {
        return delegate.manage();
    }

    @Override
    public Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) delegate).executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        return ((JavascriptExecutor) delegate).executeAsyncScript(script, args);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return ((TakesScreenshot) delegate).getScreenshotAs(target);
    }

    @Override
    public Capabilities getCapabilities() {
        return ((HasCapabilities) delegate).getCapabilities();
    }

    @Override
    public WebDriver getWrappedDriver() {
        return ((WrapsDriver) delegate).getWrappedDriver();
    }
}
