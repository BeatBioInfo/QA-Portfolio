package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage
{
    WebDriver driver;
    private By modalLoginHeader = By.id("logInModalLabel");
    private  By usernameField = By.cssSelector("input#loginusername");
    private By passwordField = By.cssSelector("input#loginpassword");
    private By loginButton = By.cssSelector("div#logInModal > div[role='document'] .btn.btn-primary");
    private By closeButton = By.cssSelector("div#logInModal > div[role='document'] .btn.btn-secondary");
    private By logoutLinkText = By.id("logout2");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getModalLoginHeader()
    {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement getHeaderTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(modalLoginHeader));
        return getHeaderTitle.getText();
    }
    public void setUsername(String username)
    {
        WebElement setUserName = driver.findElement(usernameField);
        setUserName.clear();
        setUserName.sendKeys(username);
    }
    public void setPassword(String password)
    {
        WebElement setPassword = driver.findElement(passwordField);
        setPassword.clear();
        setPassword.sendKeys(password);
    }

    public void clickCloseButton ()
    {
        driver.findElement(closeButton).click();
    }

    public void clickLogoutButton()
    {
        driver.findElement(logoutLinkText).click();
    }

    public void acceptLoginErrorAlert()
    {
        driver.switchTo().alert().accept();
    }
    public String getErrorLoginAlertMessage(String text)
    {
        driver.switchTo().alert().getText();
        return text;
    }
    public HomePage clickLoginButton()
    {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement clickable = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        clickable.click();
        return new HomePage(driver);
    }

}
