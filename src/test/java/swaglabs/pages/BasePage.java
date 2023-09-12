package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import swaglabs.utilities.ConfigurationReader;
import java.time.Duration;

public abstract class BasePage {

    private static WebDriver driver;
    private static WebDriverWait wait5;

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public static WebDriver getDriver() {
        if(driver == null){

            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome" -> driver = new ChromeDriver();
                case "firefox" -> driver = new FirefoxDriver();
            }
        }
        return driver;
    }
    public static WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        }
        return wait5;
    }

}
