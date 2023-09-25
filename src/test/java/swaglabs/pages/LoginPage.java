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

    @FindBy(xpath = "//div/form/div[3]")
    public WebElement errorMsg;

//    @FindBy(xpath = "//h3[text()='Epic sadface: Sorry, this user has been locked out.']")
//    public WebElement errorMsgUserBlocked;

    @FindBy(xpath = "//div[.='Swag Labs']")
    public WebElement loginLogo;

    public ProductsPage validLogin(int num){
        userName.sendKeys(getProperty("userName" + num));
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

    public ProductsPage validLogin() {
        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginBtn.click();

        return new ProductsPage(driver);
    }

}
