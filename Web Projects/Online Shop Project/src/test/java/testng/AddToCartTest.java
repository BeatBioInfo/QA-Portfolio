package testng;

import pageObject.DashBoard;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddToCartTest extends LoginTests {
    @Test
    public void testScrollToViewWomen() {
        DashBoard dashBoard = new DashBoard(driver);
//        testSuccessfulLogin();
        assertEquals(dashBoard.scrollItemToView(),
                "WOMEN",
                "WOMEN not visible");
        dashBoard.clickOnWomenSection();
        Assert.assertTrue(dashBoard.isWomenSectionExpanded(),
                "Women section should be expanded");
        List<WebElement> items = dashBoard.getWomenSectionItems();
        Assert.assertFalse(items.isEmpty(),
                "Women section should have items");
        // Optionally, print the items to the console
        for (WebElement item : items) {
            System.out.println("Item: " + item.getText());
        }
    }
    @Test
    public void testAddProductsToCart()
    {
//        testScrollToViewWomen();
        DashBoard dashBoard = new DashBoard(driver);
        dashBoard.NavigateToWomenTopProducts();
        dashBoard.addFancyGreenTopToCart();
        dashBoard.clickContinueShopping();
        dashBoard.addSummerWhiteTopToCart();
        dashBoard.clickViewCart();
    }
}
