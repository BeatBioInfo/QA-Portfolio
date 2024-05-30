package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage
{
    private WebDriver driver;
    private By homePageHeader = By.id("nava");
    private By HomePagefooter = By.cssSelector(".m-0.text-center.text-white");
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    private void clicklink(String linkTest)
    {
        driver.findElement(By.linkText(linkTest)).click();
    }
    public String getHomePageHeader()
    {
       return driver.findElement(homePageHeader).getText();
    }
//    Using JS to scroll an object to view
    public String scrollToFooter()
    {
        WebElement footerNote = driver.findElement(HomePagefooter);
        String script = "arguments[0].scrollIntoView();";
//        the js executor is casted to take in the JS
        ((JavascriptExecutor)driver).executeScript(script, footerNote);
        return footerNote.getText();
    }
        public LoginPage clickLoginLinkText() {
        clicklink("Log in");
        return new LoginPage(driver);
    }
}
