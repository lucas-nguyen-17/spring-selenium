package com.giangtester.localhost.framework;

import com.giangtester.localhost.chapter7.SeleniumRunner;
import com.giangtester.localhost.framework.pages.BookstoreHomepage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SeleniumRunner
public class BookstoreSearchIT {
    @Autowired
    private Browser browser;

    @Test
    public void searchBook() {
        browser.get("/bookstore/");
        new BookstoreHomepage(browser) {{
            searchBook("Selenium WebDriver Book");
        }};
    }
}
