package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Text;

import java.time.Duration;

public class PaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By nameOnCardField = By.xpath("/html//form[@id='payment-form']//input[@name='name_on_card']");
    private By cardNumberField = By.xpath("/html//form[@id='payment-form']//input[@name='card_number']");
    private By cvcField = By.xpath("/html//form[@id='payment-form']//input[@name='cvc']");
    private By expirationField = By.xpath("/html//form[@id='payment-form']//input[@name='expiry_month']");
    private By yearField = By.xpath("/html//form[@id='payment-form']//input[@name='expiry_year']");
    private By confirmOrderButton = By.cssSelector("button#submit");
    private By confirmOrderSuccessMessage = By.xpath("/html//section[@id='form']//p[.='Congratulations! Your order has been confirmed!']");


    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void setNameOnCardField(String Name) {
        WebElement enterCardName = wait.until(ExpectedConditions.elementToBeClickable(nameOnCardField));

        enterCardName.sendKeys(Name);
    }

    public void setCardNumber(String CardNumber) {
        WebElement enterCardNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberField));
        enterCardNumber.sendKeys(CardNumber);
    }

    public void setCVC(String CVC) {
        WebElement enterCVC = wait.until(ExpectedConditions.visibilityOfElementLocated(cvcField));
        enterCVC.sendKeys(CVC);

    }

    public void setExpirationField(String Month) {
        driver.findElement(expirationField).sendKeys(Month);
    }

    public void setYearField(String Year) {
        WebElement enterYear = wait.until(ExpectedConditions.elementToBeClickable(yearField));
        enterYear.sendKeys(Year);
    }

    public void scrollAndConfirmOrder() {
        WebElement viewConfirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderButton));
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(script, viewConfirmButton);
        viewConfirmButton.click();
    }
    public String orderConfirmationMessage()
    {
        return driver.findElement(confirmOrderSuccessMessage).getText();
    }
}
