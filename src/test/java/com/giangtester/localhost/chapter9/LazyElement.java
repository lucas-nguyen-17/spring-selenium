package com.giangtester.localhost.chapter9;

import org.openqa.selenium.*;

import java.util.List;

public class LazyElement implements WebElement, WrapsElement{
    private final WebElement realWebElement;

    public LazyElement(WebElement realWebElement) {
        this.realWebElement = realWebElement;
    }

    @Override
    public void click() {
        realWebElement.click();
    }

    @Override
    public void submit() {
        realWebElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        realWebElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        realWebElement.clear();
    }

    @Override
    public String getTagName() {
        return realWebElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return realWebElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return realWebElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return realWebElement.isEnabled();
    }

    @Override
    public String getText() {
        return realWebElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return realWebElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return realWebElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return realWebElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return realWebElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return realWebElement.getSize();
    }


    @Override
    public Rectangle getRect() {
        return realWebElement.getRect();
    }


    @Override
    public String getCssValue(String propertyName) {
        return realWebElement.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return realWebElement.getScreenshotAs(target);
    }

    @Override
    public WebElement getWrappedElement() {
        return realWebElement;
    }

   }
