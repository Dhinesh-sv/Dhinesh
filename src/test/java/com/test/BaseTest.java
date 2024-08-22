package com.test;

import com.utils.Constants;
import com.utils.LoginAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
     WebDriver driver;
     LoginAction loginAction;

    @BeforeClass
    public void setup() {
        loginAction = new LoginAction();
        loginAction.loadProperty();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Constants.APP_URL);
    }

//    @AfterClass
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();  // Clean up WebDriver
//        }
    }

