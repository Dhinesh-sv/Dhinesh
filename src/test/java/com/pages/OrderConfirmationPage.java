package com.pages;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderConfirmationPage extends BasePage {

   public OrderConfirmationPage(WebDriver driver){
       super(driver);
   }

   @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;

   @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    private WebElement orderConfirmationMsg;

    public OrderConfirmationPage verifyPageTitle(){
        Logger.info("User can see the Order Confirmation Message");
     String actualHeader = pageTitle.getText();
     Assert.assertEquals(actualHeader,"Checkout: Complete!","Header Mismatched");
        return this;
    }

    public OrderConfirmationPage verifyOrderConfirmation(){
        String actualOrderConfirmationMsg = orderConfirmationMsg.getText();
        Assert.assertEquals(actualOrderConfirmationMsg,"Thank you for your order!","OrderConfirmationMessageInvalid");
        return this;
    }

}


