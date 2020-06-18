package com.giangtester.ecommerce.homepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class HomepageTest {

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    void checkLogo() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        WebElement logo = driver.findElement(By.className("logo"));
        assertThat(logo.isDisplayed()).isTrue();
    }
}
