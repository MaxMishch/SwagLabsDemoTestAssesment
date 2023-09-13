package swaglabs.runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static swaglabs.pages.BasePage.driver;
import static swaglabs.pages.BasePage.getDriver;
import static swaglabs.utilities.ConfigurationReader.getProperty;

public class BaseTest {

    @BeforeMethod
    protected void setUp() {
        getDriver().get(getProperty("swagLabs.url"));
        driver.manage().window().maximize();
    }

    @AfterMethod
    protected void tearDown() {
        driver.quit();
        driver = null;
    }
}
