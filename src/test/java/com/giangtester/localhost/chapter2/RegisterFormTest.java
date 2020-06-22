package com.giangtester.localhost.chapter2;

import com.giangtester.localhost.BaseLocalTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterFormTest extends BaseLocalTest {

    @Test
    void showAllLabels() {
        driver.get("http://localhost:8080/registration-form.html");
        List<WebElement> labels = driver.findElements(By.xpath("//label"));
        labels.forEach(
                label -> System.out.println(String.format("---%s---", label.getText()))
        );
    }

    @Test
    void signUp() {
        driver.get("http://localhost:8080/registration-form.html");
        driver.findElement(new ByIdOrName("email")).sendKeys("giang@gcc.com");
        Actions actions = new Actions(driver);
        driver.findElement(new ByIdOrName("password")).sendKeys("12343423");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement sourceDropdown = driver.findElement(By.name("hearAbout"));
        Select hearAbout = new Select(sourceDropdown);
        hearAbout.selectByVisibleText("Advert");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ARROW_LEFT).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB, " ").perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//button")).click();


    }
}
