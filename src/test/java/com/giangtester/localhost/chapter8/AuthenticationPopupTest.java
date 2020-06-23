package com.giangtester.localhost.chapter8;

import com.giangtester.localhost.chapter7.SeleniumRunner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@SeleniumRunner
public class AuthenticationPopupTest {

    @Autowired
    private WebDriver driver;

    @ParameterizedTest
    @CsvSource({"giang.nguyen,NOThing.5"})
    void loginHTTPAuthentication(String username, String password) {
        driver.get(String.format("https://%s:%s@intranet.niteco.se/", username, password));
    }
}
