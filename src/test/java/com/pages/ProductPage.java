package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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

    public boolean verifyHeader(){
        return productHeader.isDisplayed();
    }
    public void addProduct(){
        btnAddtoCart.click();
    }

    public void goToCart(){
        btnGoToCart.click();
    }
    public String verifyCartHeader(){
       String titleCartHeader = cartHeader.getText();
       return titleCartHeader;
    }
    public void clickCheckOut(){
        btnCheckOut.click();
    }


}