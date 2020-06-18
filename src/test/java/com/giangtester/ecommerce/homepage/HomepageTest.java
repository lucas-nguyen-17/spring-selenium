package com.giangtester.ecommerce.homepage;

import com.giangtester.ecommerce.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HomepageTest extends BaseTest {

    @Test
    void checkLogo() {
        WebElement logo = driver.findElement(By.className("logo"));
        assertThat(logo.isDisplayed()).isTrue();
    }

    @Test
    void checkSlider() {
        List<WebElement> images = driver.findElements(
                new ByChained(By.id("homeslider"), By.tagName("li"), By.tagName("a")));

        images.forEach(
                image -> System.out.println(image.getAttribute("href"))
        );
    }
}
