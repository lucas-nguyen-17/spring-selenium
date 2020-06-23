package com.giangtester.localhost.chapter4;

import com.giangtester.localhost.chapter7.SeleniumRunner;
import com.giangtester.localhost.chapter7.TestEnvironmentEnv;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SeleniumRunner
public class LoginTest {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private TestEnvironmentEnv env;

    @Test
    void test1() {
        loginPage.gotoPage();
        loginPage.loginAs(env.getName(), env.getPassword());
        loginPage.loginSuccess();
    }
}
