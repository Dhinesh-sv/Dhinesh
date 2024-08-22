package com.pages;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

public LoginPage(WebDriver driver) {
    super(driver);
}

    @FindBy(id = "user-name")
     WebElement txtUsername;

    @FindBy(id = "password")
     WebElement txtPassword;

    @FindBy(id = "login-button")
     WebElement btnLogin;

    public LoginPage enterUsername(String username) {
        txtUsername.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        Logger.info("Open the login Page");
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
