package com.giangtester.localhost.framework;

import org.openqa.selenium.*;

import java.util.List;
import java.util.function.Supplier;

public class DelegatingWebElement implements WebElement {

    protected final WebElement delegateElement;

    public DelegatingWebElement(WebElement delegateElement) {
        this.delegateElement = delegateElement;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return delegateElement.findElements(by);
    }

    @Override
    public Element findElement(By by) {
        return new Element(delegateElement.findElement(by));
    }

    public Element findElement(Supplier<By> by) {
        return new Element(delegateElement.findElement(by.get()));
    }

    @Override
    public void click() {
        delegateElement.click();
    }

    @Override
    public void submit() {
        delegateElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        delegateElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        delegateElement.clear();
    }

    @Override
    public String getTagName() {
        return delegateElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return delegateElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return delegateElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return delegateElement.isEnabled();
    }

    @Override
    public String getText() {
        return delegateElement.getText();
    }

    @Override
    public boolean isDisplayed() {
        return delegateElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return delegateElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return delegateElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return delegateElement.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return delegateElement.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return delegateElement.getScreenshotAs(outputType);
    }
}
