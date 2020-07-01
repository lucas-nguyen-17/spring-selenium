package com.giangtester.localhost.framework.locators;


import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.tagName;

/**
 * This enum is the Supplier of ByTagName from Selenium By API.
 */
public enum TagName implements Supplier<By> {
    A("a"),
    BUTTON("button"),
    DIV("div"),
    FORM("form"),
    INPUT("input"),
    TABLE("table"),
    TBODY("tbody"),
    TD("td"),
    TR("tr"),
    TH("th"),
    OPTION("option");

    private final By by;

    TagName(String tag) {
        this.by = tagName(tag);
    }

    /**
     * @return the by instance variable which is a ByTagName.
     */
    @Override
    public By get() {
        return by;
    }

    @Override
    public String toString() {
        return by.toString();
    }
}
