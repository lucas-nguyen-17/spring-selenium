package com.giangtester.localhost.chapter4;

import com.giangtester.localhost.chapter7.LoadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;

@Component
public class LoginForm {

    private final WebDriver driver;

    @Autowired
    private LoadConfig config;

    @FindBy(name = "email")
    private WebElement txtEmail;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(css = ".btn.btn-primary")
    private WebElement btnSubmit;

    @FindBy(id = "change-password")
    private WebElement linkForgotPassword;

    public LoginForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginAs(String email, String password) {
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmit.click();
    }

    public void loginSuccess() {
        assertThat(driver.getTitle()).isEqualToIgnoringCase("You Are Logged In");
    }

    public void gotoPage() {
        driver.get(config.getBaseUrl() + "/login.html");
    }
}
