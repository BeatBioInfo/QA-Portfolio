package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage
{
    private WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    private By addressHeader = By.cssSelector("div:nth-of-type(2) > .heading");
    private By commentBox = By.cssSelector("div#ordermsg > textarea[name='message']");
    private By placeOrderButton = By.linkText("Place Order");

    public boolean getAddressHeader()
    {
        driver.findElement(addressHeader).getText();
        return false;
    }
    public boolean scrollCommentBoxToView()
    {
        WebElement viewCommentBox = driver.findElement(commentBox);
        String script = "arguments[0].scrollIntoView();";
        //The js executor is casted to take in the JS
        ((JavascriptExecutor) driver).executeScript(script, viewCommentBox);
        return viewCommentBox.isDisplayed();
    }
    public void enterComment (String comment)
    {
        driver.findElement(commentBox).sendKeys(comment);
    }
    public PaymentPage clickPlaceOrder ()
    {
        driver.findElement(placeOrderButton).click();
        return new PaymentPage (driver);
    }
}
