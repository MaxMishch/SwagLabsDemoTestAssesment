package swaglabs.runner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import swaglabs.pages.BasePage;

public class MainPage extends BasePage {

    public MainPage() {
        super();
    }

    @FindBy(xpath= "//div[@class='app_logo']")
    public WebElement headerLogo;

}
