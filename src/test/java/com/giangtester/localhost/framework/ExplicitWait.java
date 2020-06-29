package com.giangtester.localhost.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Supplier;

public interface ExplicitWait extends SearchScope{

    default Element await(Supplier<By> by) {
        return new FluentWait<>(this)
                .withTimeout(Duration.ofMillis(5000))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class)
                .until((ExplicitWait e) -> findElement(by));
    }

    default void click(Supplier<By> bySupplier) {
        await(bySupplier).click();
    }

    default String getText(Supplier<By> bySupplier) {
        return await(bySupplier).getText();
    }
}
