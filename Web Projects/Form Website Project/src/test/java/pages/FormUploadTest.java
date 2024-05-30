package pages;

import org.project.pages.FileUpload;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FormUploadTest extends HomePageTest
{
    @Test
    public void testFileUpload()
    {
        homePage.clickFileUpload();
        FileUpload fileUpload = new FileUpload(driver);
        fileUpload.uploadFile("C:/Users/Beatrice/Downloads/Quantori/DEMO JAVA/MyProjectFile/Formy-Automation-Project/src/main/resources/chromedriver.exe");
        assertEquals(fileUpload.getInputFieldValue("chromedriver.exe"),
                "chromedriver.exe", "Value not valid");
//        fileUpload.clickUploadButton();
//        fileUpload.resetButton();
    }

}
