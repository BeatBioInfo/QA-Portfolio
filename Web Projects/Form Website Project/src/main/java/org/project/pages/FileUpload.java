package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload 
{
    WebDriver driver;
   public FileUpload(WebDriver driver)
    {
        this.driver = driver;
    }
    private By uploadInputField = By.id("file-upload-field");
    private By uploadButton = By.xpath("//body/div[@class='container']/form/div/div/span[1]/button[@type='button']");
    private By resetButton = By.cssSelector("//body/div[@class='container']/form/div/div/span[2]/button[@type='button']");

    public void clickUploadButton()
    {
        driver.findElement(uploadButton).click();
    }
    public void resetButton()
    {
        driver.findElement(resetButton).click();
    }

    /**
     * provides path of the file to the form then clicks the upload button
     * @param absolutePathOfFile
     */
    public void uploadFile(String absolutePathOfFile)
    {
        driver.findElement(uploadInputField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    public String getInputFieldValue(String text)
    {
        WebElement inputFieldValue = driver.findElement(uploadInputField);
        String actualValue = inputFieldValue.getAttribute(text);
        return actualValue;
    }

}
