package PageTest;

import org.project.pages.AppointmentPage;
import org.project.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends HomePageTest
{
    @Test(priority = 2)
    public void testSuccessfulLogin()
    {
        homePage.clickhamburgerIcon();
        LoginPage loginPage = homePage.clicklogin();
        loginPage.setUserName("John Doe");
        loginPage.setPassword("ThisIsNotAPassword");
        AppointmentPage appointmentPage = loginPage.clickLoginButton();
        assertTrue(appointmentPage.getPageHeader().
                contains("Make Appointment"),
                "Page header incorrect");
    }
    @Test(priority = 1)
    public void testFailedLoginAttempt()
    {
        homePage.clickhamburgerIcon();
        LoginPage loginPage = homePage.clicklogin();
        loginPage.setUserName("ThisIsNotAPassword");
        loginPage.setPassword("John Doe");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getFailedAlertMessage().
                contains("Login failed! Please ensure the username and password are valid."),
                "Alert message is incorrect");
        loginPage.viewPageHeader();
        assertTrue(loginPage.getLoginPageHeader().
                contains("CURA Healthcare Service"),
                "Header Page is incorrect");

    }
}
