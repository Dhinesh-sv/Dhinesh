package com.test;

import com.base.BasePage;
import com.pages.LoginPage;
import com.pages.OrderConfirmationPage;
import com.pages.ProductPage;
import com.pages.ShippingDetailsPage;
import com.utils.Constants;
import com.utils.LoginAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_Test extends BasePage {
     WebDriver driver;
     LoginPage loginPage;
     ProductPage productPage;
     LoginAction loginAction = new LoginAction();
    ShippingDetailsPage shippingDetailsPage;
    OrderConfirmationPage orderConfirmationPage;

   @BeforeTest
    public void setup(){
       loginAction.loadProperty();
//     launchUrl(Constants.APP_URL);
//      implicitWait();
        driver = new ChromeDriver();
        driver.get(Constants.APP_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       loginPage = new LoginPage(driver);
       productPage = new ProductPage(driver);
       shippingDetailsPage = new ShippingDetailsPage(driver);
       orderConfirmationPage = new OrderConfirmationPage(driver);
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

       shippingDetailsPage.verifyShippingPageHeader()
               .userEnterShippingDetails(Constants.FIRSTNAME,
               Constants.LASTNAME,Constants.ZIPCODE)
               .clickContinueButton()
               .verifyCheckoutTitle()
               .clickFinishButton();

       orderConfirmationPage.verifyPageTitle()
               .verifyOrderConfirmation();
   }

//   @AfterTest
//    public void tearDown(){
//     //  driver.quit();

   }




