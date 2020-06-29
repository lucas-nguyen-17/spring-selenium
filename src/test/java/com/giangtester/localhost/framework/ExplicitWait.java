package com.giangtester.localhost.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Supplier;

public interface ExplicitWait {
    WebElement findElement(Supplier<By> by);

    default WebElement await(Supplier<By> by) {
        return new FluentWait<>(this)
                .withTimeout(Duration.ofMillis(5000))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class)
                .until((ExplicitWait e) -> findElement(by));
    }
}
