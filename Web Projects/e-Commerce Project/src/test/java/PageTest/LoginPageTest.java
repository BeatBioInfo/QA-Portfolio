package PageTest;

import org.openqa.selenium.Keys;
import org.project.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class LoginPageTest extends HomePageTest
{
    @Test(priority = 3)
    public void testSuccessfulLogin()
    {
        LoginPage loginPage = homePage.clickLoginLinkText();
        assertEquals (loginPage.getModalLoginHeader(),  "Log in", "Header not visible");
        loginPage.setUsername("lorijyram");
        loginPage.setPassword("Beatrice");
        loginPage.clickLoginButton();
        assertTrue(homePage.getHomePageHeader().contains("PRODUCT STORE"), "Header not displayed");
        getWindowManager().refreshPage();
        getWindowManager().goTo("https://ecommerce-playground.lambdatest.io/");
        getWindowManager().goBack();

     }
    @Test(priority = 2)
    public void testUnsuccessfulLogin()
    {
        LoginPage loginPage = homePage.clickLoginLinkText();
        assertEquals (loginPage.getModalLoginHeader(),  "Log in", "Header not visible");
        loginPage.setUsername("" + Keys.BACK_SPACE);
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        String text = loginPage.getErrorLoginAlertMessage("Please fill out Username and Password.");
        assertEquals(text, "Please fill out Username and Password.", "Alert text incorrect");
        loginPage.acceptLoginErrorAlert();
        loginPage.clickCloseButton();
    }
    @Test(priority = 1)
    public void testToCloseLoginModal()
    {
        LoginPage loginPage = homePage.clickLoginLinkText();
        assertEquals (loginPage.getModalLoginHeader(),  "Log in", "Header not visible");
        loginPage.clickCloseButton();
        assertTrue(homePage.getHomePageHeader().contains("PRODUCT STORE"), "Header not displayed");
    }
  }
