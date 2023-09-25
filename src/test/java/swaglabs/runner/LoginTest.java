package swaglabs.runner;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import swaglabs.pages.LoginPage;

public class LoginTest extends BaseTest{

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
