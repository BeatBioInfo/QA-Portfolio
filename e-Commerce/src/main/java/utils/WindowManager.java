package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager
{
    private WebDriver driver;
    private WebDriver.Navigation navigate;


    public WindowManager(WebDriver driver)
    {
        this.driver = driver;
        navigate = driver.navigate();
    }
    public void goBack()
    {
        navigate.back();
    }
    public void goForward()
    {
        navigate.forward();
    }
    public void goTo(String url)
    {
        navigate.to(url);
    }
    public void refreshPage()
    {
        navigate.refresh();
    }

}
