package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.project.pages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class HomePageTest
{
    WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public  void setUp()
    {

        System.setProperty("webdriver.chrome.driver", "/Users/Emmanuel/Downloads/DEMO JAVA/MyProjectFile/Formy-Automation-Project/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/");
        driver.manage().window().maximize();
                homePage = new HomePage(driver);

    }
    @AfterClass
    public  void tearDown()
    {
        driver.quit();
    }
}


