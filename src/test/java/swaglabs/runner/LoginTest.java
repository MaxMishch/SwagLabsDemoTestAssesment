package swaglabs.runner;

import org.testng.Assert;
import org.testng.annotations.Test;
import swaglabs.pages.LoginPage;
import static swaglabs.utilities.ConfigurationReader.getProperty;


public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage();

    //TC#1
    //1. Go to https://www.saucedemo.com/
    //2. Type valid credential into Login Page
    //3. Click Login btn
    //5. Verify Title Main Page

    @Test
    public void testValidLogin() throws InterruptedException {

        loginPage.userName.sendKeys(getProperty("userName3"));
        loginPage.password.sendKeys(getProperty("password"));
        loginPage.loginBtn.click();
//        Thread.sleep(2000);
        Assert.assertEquals("Swag Labs", new MainPage().headerLogo.getText());
    }
}
