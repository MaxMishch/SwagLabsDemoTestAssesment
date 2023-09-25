package swaglabs.runner;

import org.testng.Assert;
import org.testng.annotations.Test;
import swaglabs.pages.LoginPage;
import swaglabs.pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test
    public void testProductAddedRemovedToCart() throws InterruptedException {
        ProductsPage productPage = new LoginPage(getDriver()).validLogin();
        productPage
                .addAllItemsToCart();

        String afterAddingCartText = productPage.getTextCartLink();

        productPage
                .removeAllItemsToCart();
        String finalCartText = productPage.getTextCartLink();
        Assert.assertNotEquals(afterAddingCartText, finalCartText,
                "Cart should not be empty after adding items.");
    }
}