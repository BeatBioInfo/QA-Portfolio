package testng;

import basepackage.TestBase;
import helper.ReadConfig;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObject.LandingPage;

import java.lang.reflect.Method;

import static utilities.extentreports.ExtentTextManager.startTest;

public class E2EFromSignUpToCheckOutTest extends TestBase
{
    ReadConfig readConfig;
    SoftAssert softAssert;
    LoginTests loginTests;
    LandingPage landingPage;
    FeaturedItemTest featuredItemTest;
    AddToCartTest addToCartTest;
    PaymentAndCheckOutTest paymentAndCheckOutTest;

    private void initializer()
    {
        readConfig = new ReadConfig();
        softAssert = new SoftAssert();
        landingPage = new LandingPage(driver);
        loginTests = new LoginTests();
        featuredItemTest = new FeaturedItemTest();
        addToCartTest = new AddToCartTest();
        paymentAndCheckOutTest = new PaymentAndCheckOutTest();
    }

    @Test(priority = 1, description = "1. Go to the automated exercise website")
    public void testCase1(Method method)
    {
        startTest(method.getName(), method.getAnnotation(Test.class).description(),
                "Open the web landing page");
        initializer();
    }
    @Test(priority = 2, description = "2. Test that the designated user can login successfully")
    public void testCase2(Method method)
    {
        startTest(method.getName(), method.getAnnotation(Test.class)
                .description(), "Login successfully");
        initializer();
        loginTests.testSuccessfulLogin();
    }
    @Test(priority = 3, description = "Get all the featured items on the page and print all the fetched item on the console")
    public void testCase3(Method method)
    {
        startTest(method.getName(), method.getAnnotation(Test.class)
                .description(), "Fetch all featured item");
        initializer();
        featuredItemTest.testFetchAndSortItems();
    }
    @Test(priority = 4, description = "Scroll the women section and get the section item")
    public void testCase4(Method method)
    {
        startTest(method.getName(), method.getAnnotation(Test.class)
                .description(), "Get the item under the women section");
        initializer();
        addToCartTest.testScrollToViewWomen();
        addToCartTest.testAddProductsToCart();
    }
    @Test(priority = 5, description = "Make payment and checkout")
    public void testCase5 (Method method)
    {
        startTest(method.getName(), method.getAnnotation(Test.class)
                .description(), "Make payment to confirm order successfully");
        initializer();
        paymentAndCheckOutTest.testPaymentAndCheckOut();

    }


}
