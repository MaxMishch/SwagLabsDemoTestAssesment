package swaglabs.runner;

import org.testng.Assert;
import org.testng.annotations.Test;
import swaglabs.pages.LoginPage;;

public class LoginTest extends BaseTest{

    //TC#1
    //1. Go to https://www.saucedemo.com/
    //2. Type valid credential into Login Page
    //3. Click Login btn
    //5. Verify Title Main Page

    @Test
    public void testValidLogin() {

        String actualLogoProducts =  new LoginPage(getDriver()).validLogin().headerLogo.getText();
        String expectedLogoProducts  = "Swag Labs";
        Assert.assertEquals(actualLogoProducts, expectedLogoProducts);
    }

    @Test
    public void testInvalidLogin() {
        String actualErrorMsg =  new LoginPage(getDriver()).invalidLogin().errorMsg.getText();
        String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }
}
