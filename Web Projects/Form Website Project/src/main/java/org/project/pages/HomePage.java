package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage
{
    private WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }
    private void clicklink(String linkTest)
    {
        driver.findElement(By.linkText(linkTest)).click();
    }

    public FileUpload clickFileUpload()
    {
        clicklink("File Upload");
        return new FileUpload (driver);

    }
}
