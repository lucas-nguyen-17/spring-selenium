package com.giangtester.localhost.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

public class Browser extends DelegatingWebDriver implements FormElements{

    public Browser(WebDriver driver) {
        super(driver);
    }

    public void setInputText(Supplier<By> bySupplier, Object text) {
        Element element = await(bySupplier);
        element.clear();
        element.sendKeys(text.toString());
    }
}
