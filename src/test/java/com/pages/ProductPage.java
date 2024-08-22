package com.pages;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement productHeader;

    @FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']")
    private WebElement product;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement btnAddtoCart;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement btnGoToCart;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement btnCheckOut;

    @FindBy(xpath = " //span[text()='Your Cart']")
    private WebElement cartHeader;

    public ProductPage verifyHeader() {
        Logger.info("User Succesfully navigated to HomePage");
      String actualHomepageHeader = productHeader.getText();
      Assert.assertEquals(actualHomepageHeader,"Products","User Unable to log in");
        return this;
    }

    public ProductPage addProduct(){
        btnAddtoCart.click();
        return this;
    }

    public ProductPage goToCart() {
        Logger.info("User Added one product to cart");
        btnGoToCart.click();
        return this;
    }

    public ProductPage verifyCartHeaderAndContinue() {
        String actualCartHeader = cartHeader.getText();
        Assert.assertEquals(actualCartHeader,"Your Cart", "Cart Header is not matched with the expected result");
        return this;
    }

    public ProductPage verifyProduct() {
        Logger.info("User can able to see the products in the cart");
        String actualProductName = product.getText();
        Assert.assertEquals(actualProductName,"Sauce Labs Bolt T-Shirt","Product mismatched With the expected one");
        return this;
    }

    public ProductPage clickCheckOut() {
        btnCheckOut.click();
        return this;
    }

}