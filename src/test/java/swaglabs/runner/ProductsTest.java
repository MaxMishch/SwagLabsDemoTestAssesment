package swaglabs.runner;

import org.testng.Assert;
import org.testng.annotations.Test;
import swaglabs.pages.LoginPage;

public class ProductsTest extends BaseTest {

    @Test
    public void testLogOut(int numUser) {
        String actualLogoText = new LoginPage(getDriver()).validLogin(numUser)
                .menuClick()
                .logOutClick()
                .loginLogo.getText();
        String expectedLogoText = "Swag Labs";

        Assert.assertEquals(actualLogoText, expectedLogoText);
    }
}
