package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DashBoard {
    private WebDriverWait wait;
    private WebDriver driver;


    public DashBoard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private By womenLinkText = By.linkText("WOMEN");
    private By allLabels = By.xpath("//div[contains(@class, 'productinfo')]//p | //div[contains(@class, 'overlay-content')]//p");
    private By allPriceList = By.xpath("//div[contains(@class, 'productinfo')]//h2 | //div[contains(@class, 'overlay-content')]//h2");
    private By loggedInUser = By.linkText("Logged in as trtrytuyuiui");
    private By womenSectionHeader = By.cssSelector("h4.panel-title a[href='#Women']");
    private By womenSection = By.cssSelector("#Women.panel-collapse.in");
    private By womenSectionItems = By.cssSelector("#Women.panel-collapse.in ul li");
    private By viewCartLink = By.linkText("View Cart");
    private By continueShoppingButton = By.cssSelector(".close-modal");
    private By summerWhiteTop = By.xpath("//p[text()='Summer White Top']/ancestor::div[@class='single-products']");
    private By fancyGreenTop = By.xpath("//p[text()='Fancy Green Top']/ancestor::div[@class='single-products']");
    private By headerTitle = By.cssSelector(".text-center.title");
    String dressProductURL = "https://www.automationexercise.com/category_products/1";
    String topProductURL = "https://www.automationexercise.com/category_products/2";
    public String getLoggedInUserName ()
    {
        return driver.findElement(loggedInUser).getText();
    }
   // Method to fetch all items (label and price) with currency
   public List<Item> getAllFeaturedItems() {
       List<WebElement> itemPrices = driver.findElements(allPriceList);
       List<WebElement> itemLabels = driver.findElements(allLabels);

       List<Item> items = new ArrayList<>();
       for (int i = 0; i < itemPrices.size(); i++) {
           String priceTextWithCurrency = itemPrices.get(i).getText(); // "Rs. 400"
           String labelText = itemLabels.get(i).getText();
           if (!priceTextWithCurrency.isEmpty()) {
               items.add(new Item(labelText, priceTextWithCurrency));
           }
       }
       return items;
   }

    // Inner class to represent an item with currency
    public class Item {
        private String label;
        private String priceWithCurrency;
        public Item(String label, String priceWithCurrency) {
            this.label = label;
            this.priceWithCurrency = priceWithCurrency;
        }

        public String getLabel() {
            return label;
        }

        public String getPriceWithCurrency() {
            return priceWithCurrency;
        }

        @Override
        public String toString() {
            return "Label: " + label + ", Price: " + priceWithCurrency;
        }
    }
    public String scrollItemToView()
    {
        WebElement viewWomenLinkText = driver.findElement(womenLinkText);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(script, viewWomenLinkText);
        return viewWomenLinkText.getText();
    }
    // Method to click on the Women section header
    public void clickOnWomenSection()
    {
        WebElement womenHeaderText = driver.findElement(womenSectionHeader);
        womenHeaderText.click();
    }
    // Method to check if the Women section is expanded
    public boolean isWomenSectionExpanded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(womenSection)).isDisplayed();
    }
    // Method to get the items in the Women section
    public List<WebElement> getWomenSectionItems() {
        return driver.findElements(womenSectionItems);
    }
    public void NavigateToWomenTopProducts() {
        driver.navigate().to(dressProductURL);
        WebElement getHeaderTitle = driver.findElement(headerTitle);
        System.out.println(getHeaderTitle.getText());
        driver.navigate().to(topProductURL);
        getHeaderTitle = driver.findElement(headerTitle);  // Re-locate the element after navigation
        System.out.println(getHeaderTitle.getText());
    }
    // Method to hover over an image card and click "Add to Cart"
    private void hoverOverProductAndAddToCart(By productLocator) {
        WebElement productCard = driver.findElement(productLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(productCard).perform();

        // Wait until the overlay and button are visible
        WebElement addToCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator)).findElement(By.cssSelector(".product-overlay .add-to-cart"));
        addToCartBtn.click();
    }

    // Method to scroll to a specific product
    private void scrollToProduct(By productLocator) {
        WebElement productCard = driver.findElement(productLocator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productCard);
    }

    // Method to add the Summer White Top to the cart
    public void addSummerWhiteTopToCart() {
        hoverOverProductAndAddToCart(summerWhiteTop);
    }

    // Method to add the Fancy Green Top to the cart
    public void addFancyGreenTopToCart() {
        scrollToProduct(fancyGreenTop);
        hoverOverProductAndAddToCart(fancyGreenTop);
    }

    // Method to handle the modal and click on Continue Shopping
    public void clickContinueShopping() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
    }
    // Method to handle the modal and click on View Cart
    public CartPage clickViewCart()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink)).click();
        return new CartPage(driver);
    }
}






