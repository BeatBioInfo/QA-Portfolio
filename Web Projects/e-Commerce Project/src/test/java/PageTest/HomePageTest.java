package PageTest;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.project.pages.HomePage;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class HomePageTest {
    WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
//        setCookie();
    }

    @Test
    public void testScrollFooterNote() {
        homePage.scrollToFooter();
        assertEquals(homePage.scrollToFooter(),
                "Copyright © Product Store 2017", "Footer is not valid");
        homePage.getHomePageHeader();
        assertEquals(homePage.getHomePageHeader(),
                "PRODUCT STORE", "Header Text is invalid");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
//        To take screenshots of failed test, use this code
    public void recordFailedTest(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
            try {
                Files.move(screenshot, new File("src/main/resources/screenshot/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }
//    getting cooking/ storing cookies
//    private void setCookie()
//    {
//        Cookie cookie = new Cookie.Builder("demoblaze", "123")
//                .domain("https://www.demoblaze.com")
//                .build();
//        driver.manage().addCookie(cookie);
//    }
}


