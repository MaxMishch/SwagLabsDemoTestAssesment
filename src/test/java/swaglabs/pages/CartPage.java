package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cart_list")
    public List<WebElement> productCartList;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeButton;

    public List<String> getProductNamesInCart() {
        List<String> productNames = new ArrayList<>();

        for (WebElement productNameElementInCart : productCartList) {
            productNameElementInCart.getText();
        }
        return productNames;
    }

    public CartPage removeItemFromCart() {
        removeButton.click();
        return this;
    }

}
