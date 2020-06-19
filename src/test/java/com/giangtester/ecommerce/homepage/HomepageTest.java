package com.giangtester.ecommerce.homepage;

import com.giangtester.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
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
                new ByChained(new ByIdOrName("homeslider"), By.tagName("li"), By.tagName("a")));

        images.forEach(
                image -> System.out.println(image.getAttribute("href"))
        );
    }

    @Test
    void checkAllLinksOnPage() {
        List<WebElement> imagesOrPictures = driver.findElements(new ByAll(By.tagName("img"), By.tagName("picture")));
        System.out.println(String.format("Number of images: %d", imagesOrPictures.size()));
        imagesOrPictures.forEach(
                image -> System.out.println(image.getAttribute("src"))
        );
    }

    @Test
    void checkTextWithTagBr() {
        WebElement tagH2 = driver.findElement(By.xpath("(//h2[contains(., 'EXCEPTEUR')])[1]"));
        assertThat(tagH2.getAttribute("innerHTML")).startsWith("EXCEPTEUR").endsWith("OCCAECAT").contains("<br>");
    }
}
