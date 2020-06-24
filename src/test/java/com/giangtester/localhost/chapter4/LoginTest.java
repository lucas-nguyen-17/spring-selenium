package com.giangtester.localhost.chapter4;

import com.giangtester.localhost.chapter7.LoadConfig;
import com.giangtester.localhost.chapter7.SeleniumRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SeleniumRunner
public class LoginTest {

    @Autowired
    private LoginForm loginForm;

    @Autowired
    private LoadConfig env;

    @Test
    void test1() {
        loginForm.gotoPage();
        loginForm.loginAs(env.getName(), env.getPassword());
        loginForm.loginSuccess();
    }
}
