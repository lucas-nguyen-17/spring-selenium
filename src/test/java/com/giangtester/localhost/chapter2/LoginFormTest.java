package com.giangtester.localhost.chapter2;

import com.giangtester.localhost.BaseLocalTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginFormTest extends BaseLocalTest {

    @Test
    void locateElementsOnLoginForm() {
        driver.get("http://localhost:8080/login.html");
        driver.findElement(new ByIdOrName("email")).sendKeys("giang");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        WebElement successMsg = driver.findElement(By.tagName("h1"));
        assertThat(successMsg.getText()).isEqualToIgnoringCase("You Are Logged In");
    }

    @Test
    void checkNumberElementsOfLoginForm() {
        driver.get("http://localhost:8080/login.html");
        List<WebElement> divs = driver.findElements(By.xpath("//form[@id='login']/child::*"));
        assertThat(divs).hasSize(4);
    }
}
