package testng;

import basepackage.TestBase;
import helper.ReadConfig;
import org.testng.annotations.Test;
import pageObject.DashBoard;
import pageObject.LandingPage;
import pageObject.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginTests extends TestBase
{
    ReadConfig readConfig;
    protected LandingPage landingPage;
    protected LoginPage loginPage;

    public void initializer() {
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
    }
    @Test
    public void testSuccessfulLogin()
    {
        initializer();
        landingPage.clickLoginLinkText();
        loginPage.setEmailField("qat@mailinator.com");
        loginPage.setPasswordField("123456");
        DashBoard dashBoard = loginPage.clickLoginButton();
        assertEquals(dashBoard.getLoggedInUserName(),
                "Logged in as trtrytuyuiui",
                "Not logged in as trtrytuyuiui");

    }
}
