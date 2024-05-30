package testng;

import pageObject.DashBoard;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FeaturedItemTest extends LoginTests
{
    @Test
    public void testFetchAndSortItems()
    {
        DashBoard dashBoard = new DashBoard(driver);
//        testSuccessfulLogin();
        // Fetch all items
        List<DashBoard.Item> items = dashBoard.getAllFeaturedItems();

        // Regular expression to extract numeric value from currency string
        Pattern pattern = Pattern.compile("\\d+");

        // Sort items by price (low to high) while handling currency
        Collections.sort(items, new Comparator<DashBoard.Item>() {
            @Override
            public int compare(DashBoard.Item i1, DashBoard.Item i2) {
                Matcher m1 = pattern.matcher(i1.getPriceWithCurrency());
                Matcher m2 = pattern.matcher(i2.getPriceWithCurrency());
                if (m1.find() && m2.find()) {
                    return Integer.compare(Integer.parseInt(m1.group()), Integer.parseInt(m2.group()));
                }
                return 0;
            }
        });

        // Print sorted items
        for(DashBoard.Item item : items) {
            System.out.println(item);
        }
    }
}
