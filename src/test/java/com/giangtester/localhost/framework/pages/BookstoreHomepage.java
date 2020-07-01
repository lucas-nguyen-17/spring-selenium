package com.giangtester.localhost.framework.pages;


import com.giangtester.localhost.framework.Browser;

import static com.giangtester.localhost.framework.locators.ClassName.SEARCH_BUTTON;
import static com.giangtester.localhost.framework.locators.Id.SEARCH_INPUT;
import static com.giangtester.localhost.framework.locators.Id.SECOND_NAVBAR;

public class BookstoreHomepage {

    private Browser browser;

    public BookstoreHomepage(Browser browser) {
        this.browser = browser;
    }

    public void searchBook(String bookname) {
        browser.setInputText(SEARCH_INPUT, bookname);
        browser.await(SECOND_NAVBAR).click(SEARCH_BUTTON);
    }
}