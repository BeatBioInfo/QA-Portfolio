package utilities.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTextManager
{
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentManager.createExtentReports();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId()) ;
    }

    public static synchronized ExtentTest startTest(String testName, String desc, String category) {
        ExtentTest test = extent.createTest(testName, desc).assignCategory(category);
        extentTestMap.put((int)Thread.currentThread().getId(),test);
        return test;
    }
}
