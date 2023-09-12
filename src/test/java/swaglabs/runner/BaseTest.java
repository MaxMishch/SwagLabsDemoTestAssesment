package swaglabs.runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import static swaglabs.pages.BasePage.getDriver;
import static swaglabs.utilities.ConfigurationReader.getProperty;

public class BaseTest {

    @BeforeMethod
    protected void setUp() {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
        getDriver().get(getProperty("swagLabs.url"));
    }

    @AfterMethod
    protected void tearDown() {
        if(getDriver() != null) {
            getDriver().close();
        }
    }
}
