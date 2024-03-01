package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public  class HomePage
{
    private WebDriver driver;
    private By hamburgerIcon = By.cssSelector("a#menu-toggle > .fa.fa-bars");

    private By loginLinkText = By.cssSelector("nav#sidebar-wrapper > ul > li:nth-of-type(3) > a");

    public void clickhamburgerIcon()
    {
        driver.findElement(hamburgerIcon).click();
    }
    public LoginPage clicklogin()
    {
        driver.findElement(loginLinkText).click();
        return new LoginPage(driver);
    }
    public  HomePage (WebDriver driver)
    {
        this.driver = driver;
    }

}