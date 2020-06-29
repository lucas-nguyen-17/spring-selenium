package com.giangtester.localhost.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

public class Element implements ExplicitWait{
    private final WebElement element;

    public Element(WebElement element) {
        this.element = element;
    }

    @Override
    public WebElement findElement(Supplier<By> by) {
        return element.findElement(by.get());
    }
}
