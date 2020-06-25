package com.giangtester.localhost.chapter5;

import com.giangtester.localhost.chapter7.SeleniumRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@SeleniumRunner
public class SearchFormTest {

    @Autowired
    private WebDriver driver;

    @Test
    public void searchText() {
        SearchForm lucas = LoadingPageFactory.openPage(driver, SearchForm.class);
        lucas.searchFor("funny cats");
    }
}
