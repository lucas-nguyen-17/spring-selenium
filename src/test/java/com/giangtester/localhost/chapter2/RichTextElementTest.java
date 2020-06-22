package com.giangtester.localhost.chapter2;

import com.giangtester.localhost.BaseLocalTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RichTextElementTest extends BaseLocalTest {

    @Test
    void insertTextToEditor() {
        driver.get("http://localhost:8080/wyswyg-editor.html");
        WebElement editorFrame = driver.findElement(By.id("editor_ifr"));
        driver.switchTo().frame(editorFrame);
        WebElement body = driver.findElement(By.tagName("body"));
        body.clear();
        body.sendKeys("A paragraph of text, some of which is ");
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector(".mce-i-italic")).click();
        driver.switchTo().frame(editorFrame);
//        body.sendKeys("italics text, some of which");

    }
}
