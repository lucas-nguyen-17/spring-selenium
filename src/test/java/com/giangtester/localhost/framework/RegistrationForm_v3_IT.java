package com.giangtester.localhost.framework;

import com.giangtester.localhost.chapter7.SeleniumRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.giangtester.localhost.framework.locators.Name.EMAIL;
import static com.giangtester.localhost.framework.locators.Name.PASSWORD;

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
}
