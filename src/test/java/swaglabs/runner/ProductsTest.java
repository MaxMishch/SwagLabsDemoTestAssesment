package swaglabs.runner;

import org.testng.Assert;
import org.testng.annotations.Test;
import swaglabs.pages.LoginPage;

public class ProductsTest extends BaseTest {

    @Test
    public void testLogOut() {
        String actualLogoText = new LoginPage().validLogin()
                .menuClick()
                .logOutClick()
                .loginLogo.getText();
        String expectedLogoText = "Swag Labs";

        Assert.assertEquals(actualLogoText, expectedLogoText);
    }
}
