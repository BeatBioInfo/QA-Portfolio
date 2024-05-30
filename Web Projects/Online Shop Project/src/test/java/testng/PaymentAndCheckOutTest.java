package testng;

import pageObject.CartPage;
import pageObject.CheckOutPage;
import pageObject.DashBoard;
import pageObject.PaymentPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PaymentAndCheckOutTest extends AddToCartTest
{
    @Test
    public void testPaymentAndCheckOut()
    {
        DashBoard dashBoard = new DashBoard(driver);
//        testAddProductsToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckOut();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        System.out.println(checkOutPage.getAddressHeader());
        checkOutPage.scrollCommentBoxToView();
        checkOutPage.enterComment("Order placed.");
        checkOutPage.clickPlaceOrder();
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.setNameOnCardField("Test Card");
        paymentPage.setCardNumber("4100 0000 0000");
        paymentPage.setCVC("123");
        paymentPage.setExpirationField("01");
        paymentPage.setYearField("1990");
        paymentPage.scrollAndConfirmOrder();
        assertEquals(paymentPage.orderConfirmationMessage(),
                "Congratulations! Your order has been confirmed!",
                "Confirmation message not visible");
    }
}
