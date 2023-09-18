package swaglabs.runner;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import swaglabs.pages.LoginPage;

import java.util.NoSuchElementException;

public class LoginTest extends BaseTest{

    //TC#1rt
    //1. Go to https://www.saucedemo.com/
    //2. Type valid credential into Login Page
    //3. Click Login btn
    //5. Verify Title Main Page

    @DataProvider(name = "LoginFourUsers")
    public Object[][] getUserName() {
        return new Object[][]{{"LoginUser", 1}, {"LoginUser", 2}, {"LoginUser", 3}, {"LoginUser", 4}};}

    @Test(dataProvider = "LoginFourUsers")
    public void testValidLogin(String User, int numUser) {
        String actualLogoProducts = new LoginPage(getDriver()).validLogin(numUser).headerLogo.getText();
        String expectedLogoProducts = "Swag Labs";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualLogoProducts, expectedLogoProducts, "The Product page is not present");
    }

    @Test
    public void testInvalidLogin() {
        String actualErrorMsg =  new LoginPage(getDriver()).invalidLogin().errorMsg.getText();
        String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }
}
