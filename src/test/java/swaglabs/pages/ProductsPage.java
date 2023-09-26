package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='app_logo']")
    public WebElement headerLogo;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuBtn;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logOutBtn;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartButton;

    @FindBy(id = "shopping_cart_container")
    public WebElement cartButton;

    @FindBy(xpath = "//button[.='Add to cart']")
    public List<WebElement> addToCart;

    @FindBy(xpath = "//button[.='Remove']")
    public List<WebElement> removeButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement shoppingCartLink;

    public ProductsPage menuClick() {
        menuBtn.click();
        return this;
    }
    public LoginPage logOutClick() {
        logOutBtn.click();
        return new LoginPage(driver);
    }

    public ProductsPage addItemToCart() {
        addToCartButton.click();
        return new ProductsPage(driver);
    }

    public CartPage cartClick() {
        cartButton.click();
        return new CartPage(driver);
    }

    public void addAllItemsToCart() {
        for (WebElement item : addToCart) {
            item.click();
        }
        new ProductsPage(driver);
    }

    public void removeAllItemsToCart() {
        for (WebElement item : removeButton) {
            item.click();
        }
        new ProductsPage(driver);
    }

    public String getTextCartLink() {
      return shoppingCartLink.getText();
    }
}