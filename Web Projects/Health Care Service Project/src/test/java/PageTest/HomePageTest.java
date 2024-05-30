package PageTest;

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

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);

//        System.out.println(driver.getTitle());
//
//        WebElement hamburgerIcon = driver.findElement(By.cssSelector("a#menu-toggle > .fa.fa-bars"));
//        hamburgerIcon.click();
//
//        WebElement loginLinkText = driver.findElement(By.linkText("nav#sidebar-wrapper > ul > li:nth-of-type(3) > a"));
//        loginLinkText.click();


    }
    @AfterClass
    public  void tearDown()
    {
        driver.quit();
    }
  }
