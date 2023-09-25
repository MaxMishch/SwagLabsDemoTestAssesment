package swaglabs.runner;

import org.testng.Assert;
import org.testng.annotations.Test;
import swaglabs.pages.CartPage;
import swaglabs.pages.LoginPage;

import java.util.List;


public class CartTest extends BaseTest {

    @Test
    public void testProductCanBeAddToCart() {
        CartPage cartPage = new LoginPage(getDriver()).validLogin()
                .addItemToCart()
                .cartClick();
        List<String> productNamesInCart = cartPage.getProductNamesInCart();
        Assert.assertTrue(productNamesInCart.isEmpty(), "Cart is not empty");
    }

    @Test
    public void testProductCanBeRemovedFromCart() {
        CartPage cartPage = new LoginPage(getDriver()).validLogin()
                .addItemToCart()
                .cartClick()
                .removeItemFromCart();
        List<String> productNamesInCart = cartPage.getProductNamesInCart();
        Assert.assertTrue(productNamesInCart.isEmpty(), "Cart is empty");
    }


}
