package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    private WebDriver driver;

    private By emailField = By.cssSelector(".login-form > form[method='post'] > input[name='email']");
    private By passwordField = By.cssSelector("form[method='post'] > input[name='password']");
    private By loginButton = By.cssSelector(".login-form > form[method='post'] > .btn.btn-default");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public  void setEmailField (String email)
    {
        driver.findElement(emailField).sendKeys(email);
    }
    public  void setPasswordField (String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }
    public DashBoard clickLoginButton()
    {
        driver.findElement(loginButton).click();
        return new DashBoard(driver);
    }
}
