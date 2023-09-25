package swaglabs.runner;

import org.testng.Assert;
import org.testng.annotations.Test;
import swaglabs.pages.LoginPage;

public class ProductsTest extends BaseTest {

    @Test(dataProvider = "LoginFourUsers")
    public void testLogOut(String User, int numUser) {
        String actualLogoText = new LoginPage(getDriver()).validLogin(numUser)
                .menuClick()
                .logOutClick()
                .loginLogo.getText();
        String expectedLogoText = "Swag Labs";

        Assert.assertEquals(actualLogoText, expectedLogoText);
    }
}
