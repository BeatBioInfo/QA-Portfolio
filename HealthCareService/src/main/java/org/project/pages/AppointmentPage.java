package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class AppointmentPage {
   WebDriver driver;
    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By appointmentPageHeader = By.cssSelector("h2");
    private By appointmentFormcheckBox = By.cssSelector(".checkbox-inline");
    private By appointmentFormRadioButtonType1 = By.cssSelector("[action] [class] .radio-inline:nth-of-type(1)");
    private By appointmentFormRadioButtonType2 = By.cssSelector("[action] [class] .radio-inline:nth-of-type(2)");
    private By appointmentFormRadioButtonType3 = By.cssSelector("[action] [class] .radio-inline:nth-of-type(3)");
    private By appointmentFormDatePicker = By.cssSelector(".glyphicon.glyphicon-calendar");
    private By bookAppointmentButton = By.id("btn-book-appointment");
    private By commentField = By.id("txt_comment");
    private By anyDate = By.cssSelector("tr:nth-of-type(3) > td:nth-of-type(5)");
    private By facilityCenterDropdown = By.cssSelector("select#combo_facility");
    public String getPageHeader() {
        return driver.findElement(appointmentPageHeader).getText();
    }
    public void setComment(String comments)
    {
        WebElement comment = driver.findElement(commentField);
        comment.sendKeys(comments);
    }

    public void clickCheckBox() {
        WebElement checkBox = driver.findElement(appointmentFormcheckBox);
        if (checkBox.isSelected()) {
            // If it's checked, click it to uncheck
            checkBox.click();
        }
        checkBox.click();
    }

    public void selectRadioButtonTypes() {
        WebElement radioButtonType3 = driver.findElement(appointmentFormRadioButtonType3);
        radioButtonType3.click();
        WebElement radioButtonType1 = driver.findElement(appointmentFormRadioButtonType1);
        radioButtonType1.click();
        WebElement radioButtonType2 = driver.findElement(appointmentFormRadioButtonType2);
        radioButtonType2.click();
    }
    public void clickDatePicker ()
    {
        driver.findElement(appointmentFormDatePicker).click();
        driver.findElement(anyDate).click();
    }

    public void selectFromDropdown(String option)
    {
        Select dropdownElement = findDropDownElement();
        dropdownElement.selectByVisibleText(option);
    }
    public List<String> getSelectedOptions()
    {
        List<WebElement> selectedElements =
                findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }
    private Select findDropDownElement()
    {
        return new Select(driver.findElement(facilityCenterDropdown));
    }
    public AppointmentConfirmationPage clickBookAppointment() {
        driver.findElement(bookAppointmentButton).click();
        return new AppointmentConfirmationPage(driver);
    }
}


