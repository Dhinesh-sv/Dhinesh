import com.pages.LoginPage;
import com.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_Test {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private LoginAction loginAction = new LoginAction();

   @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        loginAction.loadProperty();
        driver.get(Constants.APP_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);

   }
   @Test(priority = 1)
    public  void login(){
       loginPage.enterUsername(Constants.USERNAME)
                .enterPassword(Constants.PASSWORD)
                .clickLogin();

   }
   @Test(priority = 2)
    public void verifyProductPage(){
       Assert.assertTrue(productPage.verifyHeader());

   }
    @Test(priority = 3)
    public void addProductToCart(){
        productPage.addProduct();
    }
    @Test(priority = 4)
    public void goToCart(){
        productPage.goToCart();
    }
    @Test(priority = 5)
    public void verifyAddToCart(){
        String cartHeader = productPage.verifyCartHeader();
        String ExpectedHeader="Your Cart";
        Assert.assertEquals(ExpectedHeader,cartHeader);
    }
    @Test(priority = 6)
    public void clickCheckOut(){
        productPage.clickCheckOut();
    }
    @Test(priority = 7)
    public void verifyUserIsOnTheShippingDetailsPage(){

    }

   @AfterTest
    public void tearDown(){
     //  driver.quit();

   }



}
