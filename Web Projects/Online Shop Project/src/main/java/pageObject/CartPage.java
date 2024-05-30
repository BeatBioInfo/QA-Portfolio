package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage
{

    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By checkOutLinkText = By.linkText("Proceed To Checkout");
    public CheckOutPage clickCheckOut()
    {
        WebElement checkOut = driver.findElement(checkOutLinkText);
        checkOut.click();
        return new CheckOutPage (driver);
    }


}
