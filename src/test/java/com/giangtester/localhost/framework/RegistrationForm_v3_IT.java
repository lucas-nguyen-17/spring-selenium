package com.giangtester.localhost.framework;

import com.giangtester.localhost.chapter7.SeleniumRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.giangtester.localhost.framework.locators.Name.*;
import static com.giangtester.localhost.framework.locators.TagName.BUTTON;

@SeleniumRunner
public class RegistrationForm_v3_IT {

    @Autowired
    private Browser browser;

    @BeforeEach
    public void setUp() throws Exception {
        browser.get("/registration-form.html");
    }

    @Test
    void textInput() {
        browser.setInputText(EMAIL, "giang.nguyen@niteco.se");
        browser.setInputText(PASSWORD, "1234556");
    }

    @Test
    public void register() throws Exception {
        browser.get("/registration-form-new.html");

        browser.setInputText(EMAIL, "john@doe.com");
        browser.setInputText(PASSWORD, "secret");
        browser.selectByVisibleText(HEAR_ABOUT, "Friend");
        browser.setRadio(CONTACT, "email");
        browser.selectByVisibleText(INTEREST, "Movies", "Music");
        browser.setInputText(TELLUS, "---");
        browser.setCheckboxValue(TERMS, true);
        browser.click(BUTTON);

        browser.await((SearchScope d) -> browser.getTitle().contains("Thank You"));
    }
}
