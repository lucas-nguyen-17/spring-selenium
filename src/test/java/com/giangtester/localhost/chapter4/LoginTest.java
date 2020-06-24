package com.giangtester.localhost.chapter4;

import com.giangtester.localhost.chapter7.SeleniumRunner;
import com.giangtester.localhost.chapter7.TestEnvironment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SeleniumRunner
public class LoginTest {

    @Autowired
    private LoginForm loginForm;

    @Autowired
    private TestEnvironment env;

    @Test
    void test1() {
        loginForm.gotoPage();
        loginForm.loginAs(env.getName(), env.getPassword());
        loginForm.loginSuccess();
    }
}
