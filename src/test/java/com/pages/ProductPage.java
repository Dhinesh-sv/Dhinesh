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

    public ProductPage verifyHeader() {
        if (productHeader.isDisplayed()) {
            System.out.println("Header is displayed.");
        } else {
            System.out.println("Header is not displayed.");
        }
        return this;
    }

    public ProductPage addProduct(){
        btnAddtoCart.click();
        return this;
    }


    public ProductPage goToCart() {
        btnGoToCart.click();
        return this;
    }

    public ProductPage verifyCartHeaderAndContinue() {
        String titleCartHeader = cartHeader.getText();
        System.out.println("Cart Header: " + titleCartHeader);
        return this;
    }

    public ProductPage verifyProduct() {
        if (product.isDisplayed()) {
            System.out.println("Product is matched");
        } else {
            System.out.println("Product Mismatched");
        }
        return this;
    }

    public ProductPage clickCheckOut() {
        btnCheckOut.click();
        return this;
    }



}