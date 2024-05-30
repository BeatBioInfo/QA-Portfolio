package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private WebDriver driver;
    private By loginLink = By.linkText("Signup / Login");
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginLinkText() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }


}
