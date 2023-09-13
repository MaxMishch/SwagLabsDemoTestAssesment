package swaglabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    public ProductsPage() {
        super();
    }

    @FindBy(xpath= "//div[@class='app_logo']")
    public WebElement headerLogo;

}
