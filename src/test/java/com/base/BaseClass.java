package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseClass {
    WebDriver driver;
    public void launchUrl(String Url){
        driver = new ChromeDriver();
        driver.get(Url);
    }
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void maximize() {
        driver.manage().window().maximize();
    }
    public void sendValuestoTextBox(@org.jetbrains.annotations.NotNull WebElement element, String value) {
        element.sendKeys(value);
    }
    public static void click(WebElement element) {
        element.click();

    }

}
