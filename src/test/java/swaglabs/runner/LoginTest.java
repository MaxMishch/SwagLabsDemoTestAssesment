package swaglabs.runner;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import swaglabs.pages.BasePage;
import swaglabs.pages.LoginPage;;
import swaglabs.pages.ProductsPage;
import static swaglabs.pages.BasePage.getWait;
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

        loginPage = new LoginPage();
        loginPage.userName.sendKeys(getProperty("userName3"));
        loginPage.password.sendKeys(getProperty("password"));

        getWait().until(ExpectedConditions.elementToBeClickable(loginPage.loginBtn)).click();
        Assert.assertEquals("Swag Labs", new ProductsPage().headerLogo.getText());
    }

    @Test
    public void testInvalidLogin() throws InterruptedException {

        loginPage = new LoginPage();
        loginPage.userName.sendKeys("standard_user1");
        loginPage.password.sendKeys(getProperty("password"));
        loginPage.loginBtn.click();

        String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.errorMsg.getText(), expectedErrorMsg);
    }
}
