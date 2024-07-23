package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class Steps {
    WebDriver driver;

    @Given("User is on the Adactin Hotel login page")
    public void user_is_on_the_adactin_hotel_login_page() {

        WebDriver  driver = new ChromeDriver();
        driver.get("http://adactin.com/HotelApp/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("User enters valid {string} and {string}")
    public void user_enters_valid_and(String username, String password) {
        driver.findElement(By.id("username")).sendKeys("Dhinesh7");
        driver.findElement(By.id("username")).sendKeys("Dhinesh7");
        driver.findElement(By.id("password")).sendKeys("Dhinesh@07");
    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.id("login")).click();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        assertTrue(driver.findElement(By.id("logout")).isDisplayed());
        driver.quit();
    }
    @Given("User is logged in to Adactin Hotel")
    public void user_is_logged_in_to_adactin_hotel() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://adactin.com/HotelApp/");

        // Login logic (assuming it's already implemented in previous steps)
        driver.findElement(By.id("username")).sendKeys("Dhinesh7");
        driver.findElement(By.id("password")).sendKeys("Dhinesh@07");
        driver.findElement(By.id("login")).click();
        assertTrue(driver.findElement(By.id("logout")).isDisplayed());
    }

    @When("User selects location, hotel, room type, check-in/out dates, and guests")
    public void user_selects_hotel_details() {
        // Example selections (replace with actual element locators and values)
        driver.findElement(By.id("location")).sendKeys("New York");
        driver.findElement(By.id("hotels")).sendKeys("Hotel Sunshine");
        driver.findElement(By.id("room_type")).sendKeys("Deluxe");
        driver.findElement(By.id("datepick_in")).sendKeys("07/20/2024");
        driver.findElement(By.id("datepick_out")).sendKeys("07/25/2024");
        driver.findElement(By.id("adult_room")).sendKeys("2");
        driver.findElement(By.id("child_room")).sendKeys("1");
    }

    @And("User clicks on Search button")
    public void user_clicks_on_search_button() {
        driver.findElement(By.id("Submit")).click();
    }

    @Then("User should see available hotels")
    public void user_should_see_available_hotels() {
        assertTrue(driver.findElement(By.id("available_hotels")).isDisplayed());
    }

    @When("User selects a hotel and clicks on Continue")
    public void user_selects_hotel_and_continue() {
        // Assuming logic to select a hotel from search results and continue
        driver.findElement(By.id("select_hotel")).click();
        driver.findElement(By.id("continue")).click();
    }

    @And("User fills in booking details and clicks on Book Now")
    public void user_fills_booking_details_and_book_now() {
        // Example booking details (replace with actual element locators and values)
        driver.findElement(By.id("first_name")).sendKeys("John");
        driver.findElement(By.id("last_name")).sendKeys("Doe");
        driver.findElement(By.id("address")).sendKeys("123 Street, City");
        driver.findElement(By.id("cc_num")).sendKeys("1234567890123456");
        driver.findElement(By.id("cc_type")).sendKeys("VISA");
        driver.findElement(By.id("cc_exp_month")).sendKeys("07");
        driver.findElement(By.id("cc_exp_year")).sendKeys("25");
        driver.findElement(By.id("cc_cvv")).sendKeys("123");
        driver.findElement(By.id("book_now")).click();
    }

    @Then("User should see booking confirmation")
    public void user_should_see_booking_confirmation() {
        assertTrue(driver.findElement(By.id("booking_confirmation")).isDisplayed());
        driver.quit();
    }

}

