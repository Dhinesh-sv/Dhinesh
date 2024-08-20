package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "login-button")
    private WebElement btnLogin;

    public LoginPage enterUsername(String username) {
        txtUsername.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        txtPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        btnLogin.click();
        return this;
    }

    public LoginPage login(String username, String password) {
         enterUsername(username)
                .enterPassword(password)
                .clickLogin();
         return this;
    }

}
