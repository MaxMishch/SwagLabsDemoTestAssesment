package swaglabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage() {
        super();
    }
    @FindBy(id= "user-name")
    public WebElement userName;

    @FindBy(id= "password")
    public WebElement password;

    @FindBy(id= "login-button")
    public WebElement loginBtn;

}
