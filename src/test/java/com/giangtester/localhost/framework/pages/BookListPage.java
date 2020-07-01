package com.giangtester.localhost.framework.pages;


import com.giangtester.localhost.framework.Browser;
import org.openqa.selenium.By;

public class BookListPage {

    private Browser browser;

    public BookListPage(Browser browser) {
        this.browser = browser;
    }

    public void chooseBook(String bookname) {
        browser.click(() -> By.partialLinkText(bookname));
    }
}