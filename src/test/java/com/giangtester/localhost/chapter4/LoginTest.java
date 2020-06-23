package com.giangtester.localhost.chapter4;

import com.giangtester.localhost.chapter7.SeleniumRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SeleniumRunner
public class LoginTest {

    @Autowired
    private LoginPage loginPage;

    @Test
    void test1() {
        loginPage.gotoPage();
        loginPage.loginAs("giang", "1234");
        loginPage.loginSuccess();
    }
}
