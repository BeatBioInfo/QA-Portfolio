package utilities.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager
{
    public static final ExtentReports extentReports = new ExtentReports();


    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports");
        reporter.config().setReportName("AUTOMATION EXERCISE WEBSITE REPORT");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Test Name", "Automation Exercise Website");
        extentReports.setSystemInfo("Author", "Oluwakemisola");
        return extentReports;
    }
}
