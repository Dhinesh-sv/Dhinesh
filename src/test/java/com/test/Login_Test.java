package com.test;

import com.base.BasePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utils.Constants;
import com.utils.LoginAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_Test extends BasePage {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private LoginAction loginAction = new LoginAction();

   @BeforeTest
    public void setup(){
       loginAction.loadProperty();


//       launchUrl(Constants.APP_URL);
//       maximize();
//       implicitWait();
        driver = new ChromeDriver();
        driver.get(Constants.APP_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       loginPage = new LoginPage(driver);
       productPage = new ProductPage(driver);

   }

   @Test
    public  void login(){

       loginPage.login(Constants.USERNAME,
               Constants.PASSWORD);

       productPage.verifyHeader()
               .addProduct()
               .goToCart()
               .verifyCartHeaderAndContinue()
               .verifyProduct()
               .clickCheckOut();

   }

//   @AfterTest
//    public void tearDown(){
//     //  driver.quit();

   }




