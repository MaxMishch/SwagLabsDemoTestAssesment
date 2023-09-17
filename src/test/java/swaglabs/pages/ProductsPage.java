package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath= "//div[@class='app_logo']")
    public WebElement headerLogo;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuBtn;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logOutBtn;

    public ProductsPage menuClick() {
        menuBtn.click();
        return this;
    }
    public LoginPage logOutClick() {
        logOutBtn.click();
        return new LoginPage(driver);
    }
}
