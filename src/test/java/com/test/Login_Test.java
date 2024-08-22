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
import org.testng.annotations.*;

import java.time.Duration;

public class Login_Test extends BaseTest {
     LoginPage loginPage;
     ProductPage productPage;
     ShippingDetailsPage shippingDetailsPage;
     OrderConfirmationPage orderConfirmationPage;

    @BeforeClass
    public void init() {
    loginPage = new LoginPage(driver);
    productPage = new ProductPage(driver);
    shippingDetailsPage = new ShippingDetailsPage(driver);
    orderConfirmationPage = new OrderConfirmationPage(driver);
}

   @Test
    public  void loginTest() {
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

  @AfterTest
   public void tearDown(){
       driver.quit();
   }
}




