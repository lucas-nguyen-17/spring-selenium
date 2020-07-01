package com.giangtester.localhost.framework.locators;

import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.linkText;

public enum LinkText implements Supplier<By> {
    CHOOSE_LOCATION("choose location"),
    MEXICO("MEXICO"),
    CANCUN("Cancun");

    private final By by;

    LinkText(String linkText) {
        this.by = linkText(linkText);
    }

    @Override
    public By get() {
        return by;
    }

    @Override
    public String toString() {
        return by.toString();
    }
}
