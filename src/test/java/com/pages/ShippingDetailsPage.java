package com.pages;

import com.base.BasePage;
import com.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShippingDetailsPage extends BasePage {

    public ShippingDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".title")
    private WebElement shippingDetailsHeader;

    @FindBy(id = "first-name")
    private WebElement txtFirstName;

    @FindBy(id = "last-name")
    private WebElement txtLastName;

    @FindBy(id = "postal-code")
    private WebElement txtZipcode;

    @FindBy(xpath  = "//input[@class='submit-button btn btn_primary cart_button btn_action']")
    private WebElement btnContinue;

    @FindBy(xpath  = "//button[text()='Finish']")
    private WebElement btnFinish;

    @FindBy(css = "span[class='title']")
    private WebElement checkoutTitle;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement getBtnFinish;


    public  ShippingDetailsPage verifyShippingPageHeader(){
        String actualHeader = shippingDetailsHeader.getText();
        Assert.assertEquals(actualHeader,"Checkout: Your Information","Header is Mismatched");
        return this;
    }

    public ShippingDetailsPage firstName(String FirstName){
        Logger.info("User is on the Shipping Information page");
        txtFirstName.sendKeys(FirstName);
        return this;
    }

    public ShippingDetailsPage lastName(String LastName){
        txtLastName.sendKeys(LastName);
        return this;
    }

    public ShippingDetailsPage zipCode(String Zipcode){
        txtZipcode.sendKeys(Constants.ZIPCODE);
        return this;
    }

    public ShippingDetailsPage userEnterShippingDetails(String FirstName,String LastName,String Zipcode){
        firstName(FirstName)
                .lastName(LastName)
                .zipCode(Zipcode);
        return this;
    }

    public ShippingDetailsPage clickContinueButton(){
        btnContinue.click();
        return this;
    }

    public  ShippingDetailsPage verifyCheckoutTitle(){
        Logger.info("User is on the CheckOutPage");
        String actualTitle = checkoutTitle.getText();
        Assert.assertEquals(actualTitle,"Checkout: Overview","Title for Checkout Page is Mismatched");
        return this;
    }

    public ShippingDetailsPage clickFinishButton(){
        btnFinish.click();
        return this;
    }

}



