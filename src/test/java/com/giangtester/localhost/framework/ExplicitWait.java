package com.giangtester.localhost.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface ExplicitWait extends SearchScope{

    default Element await(Supplier<By> by) {
        return await((SearchScope e) -> e.findElement(by));
    }

    default void await(Predicate<SearchScope> predicate) {
        await((Function<SearchScope, Boolean>) predicate::test);
    }

    default <T> T await(Function<SearchScope, T> function) {
        return new FluentWait<>(this)
                .withTimeout(Duration.ofMillis(5000))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class)
                .until(
                        (SearchScope where) -> function.apply(where)
                );
    }

    default String getText(Supplier<By> by) {
        return await(by).getText();
    }

    default String getUpperText(Supplier<By> by) {
        return await(by).getText().toUpperCase();
    }

    default void click(Supplier<By> by) {
        await(by).click();
    }
}
