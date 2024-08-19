import com.base.BaseClass;
import com.pages.LoginPage;
import com.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginAction {



    public void loadProperty() {
        Properties properties = new Properties();
        try {
            FileInputStream fileInput = new FileInputStream("config.properties");
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Constants.APP_URL= properties.getProperty("APP_URL");
        Constants.USERNAME = properties.getProperty("USERNAME");
        Constants.PASSWORD = properties.getProperty("PASSWORD");

    }






}
