package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {

    public static final Logger Logger= LoggerFactory.getLogger(BasePage.class);
    WebDriver driver;
    public void launchUrl(String Url){
        driver = new ChromeDriver();
        driver.get(Url);
        driver.manage().window().maximize();


    }
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void maximize() {
        Logger.info("I am In Base ");
        driver.manage().window().maximize();
    }
    public void sendValuestoTextBox(WebElement element, String value) {
        element.sendKeys(value);
    }
    public static void click(WebElement element) {
        element.click();

    }

}
