package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static swaglabs.utilities.ConfigurationReader.getProperty;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id= "user-name")
    public WebElement userName;

    @FindBy(id= "password")
    public WebElement password;

    @FindBy(id= "login-button")
    public WebElement loginBtn;

    @FindBy(xpath = "//h3[text()='Epic sadface: Username and password do not match any user in this service']")
    public WebElement errorMsg;

    @FindBy(xpath = "//div[.='Swag Labs']")
    public WebElement loginLogo;

    public ProductsPage validLogin(){
        userName.sendKeys(getProperty("userName3"));
        password.sendKeys(getProperty("password"));
        loginBtn.click();

        return new ProductsPage(driver);
    }

    public LoginPage invalidLogin(){
        userName.sendKeys("invalidLoginName");
        password.sendKeys(getProperty("password"));
        loginBtn.click();

        return this;
    }

}
