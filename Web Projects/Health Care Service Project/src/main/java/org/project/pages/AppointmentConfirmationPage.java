package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentConfirmationPage 
{
    private WebDriver driver;
        public AppointmentConfirmationPage(WebDriver driver)
    {
        this.driver = driver;

    }
    private By appointmentConfirmationAlert = By.cssSelector("h2");
    private By confirmationText = By.cssSelector(".lead");
    private By returnToHomePageButton = By.cssSelector(".btn.btn-default");
    public String getAppointmentConfirmationHeader() {
        return driver.findElement(appointmentConfirmationAlert).getText();
    }
    public String getConfirmationTextHeader() {
        return driver.findElement(confirmationText).getText();
    }
    public HomePage returnToHomePage()
    {
        driver.findElement(returnToHomePageButton);
        return new HomePage(driver);
    }

}
