package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage
{
    private WebDriver driver;
    private By usernameField = By.id("txt-username");
    private By passwordField = By.id("txt-password");
    private By loginButton = By.id("btn-login");
    private By failedLoginAlert = By.cssSelector(".lead.text-danger");
    private By moveToTopIcon = By.cssSelector("a#to-top > .fa.fa-1x.fa-chevron-up.fa-fw");
    private By loginPageHeader = By.cssSelector("h1");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String Username)
    {
        WebElement userNameField = driver.findElement(usernameField);
        userNameField.clear();
        userNameField.sendKeys(Username);
    }
    public void setPassword(String Password)
    {
        WebElement passWordField = driver.findElement(passwordField);
        passWordField.clear();
        passWordField.sendKeys(Password);
    }
    public String getFailedAlertMessage() {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement failedLoginAlertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(failedLoginAlert));
        return failedLoginAlertElement.getText();
    }
    public void viewPageHeader()
    {
        driver.findElement(moveToTopIcon).click();
    }
    public String getLoginPageHeader() {
        return driver.findElement(loginPageHeader).getText();
    }
    public AppointmentPage clickLoginButton ()
    {
        driver.findElement(loginButton).click();
        return new AppointmentPage(driver);
    }


}
