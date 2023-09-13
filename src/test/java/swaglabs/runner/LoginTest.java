package swaglabs.runner;

import org.testng.Assert;
import org.testng.annotations.Test;
import swaglabs.pages.LoginPage;
import static swaglabs.pages.BasePage.getDriver;
import static swaglabs.utilities.ConfigurationReader.getProperty;


public class LoginTest extends BaseTest{

    LoginPage loginPage;

    //TC#1
    //1. Go to https://www.saucedemo.com/
    //2. Type valid credential into Login Page
    //3. Click Login btn
    //5. Verify Title Main Page

    @Test
    public void testValidLogin() throws InterruptedException {

        Thread.sleep(1000);
        loginPage = new LoginPage();
        loginPage.userName.sendKeys(getProperty("userName3"));
        loginPage.password.sendKeys(getProperty("password"));
        loginPage.loginBtn.click();
        Thread.sleep(1000);
        Assert.assertEquals("Swag Labs", new MainPage().headerLogo.getText());
        getDriver().quit();
    }

    @Test
    public void testInvalidLogin() throws InterruptedException {

        Thread.sleep(1000);
        loginPage = new LoginPage();
        loginPage.userName.sendKeys("standard_user1");
        loginPage.password.sendKeys(getProperty("password"));
        loginPage.loginBtn.click();

        String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.errorMsg.getText(), expectedErrorMsg);
    }
}
