package swaglabs.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import swaglabs.utilities.ConfigurationReader;
import java.time.Duration;
import static swaglabs.utilities.ConfigurationReader.getProperty;

public abstract class BaseTest {

    private WebDriver driver;
    protected WebDriverWait wait;
    public WebDriver getDriver() {
        if(driver == null){

            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome" -> driver = new ChromeDriver();
                case "firefox" -> driver = new FirefoxDriver();
            }
        }
        return driver;
    }
    public WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }
        return wait;
    }

    @BeforeMethod
    protected void setUp() {
        getDriver().get(getProperty("swagLabs.url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.manage().window().maximize();
    }

    @AfterMethod
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
