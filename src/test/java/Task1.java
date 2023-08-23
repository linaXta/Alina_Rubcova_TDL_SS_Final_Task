import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.DialogBoxesPage;

import java.io.File;
import java.io.IOException;

public class Task1 extends TestBase {

    private WebDriver driver;
    static ExtentReports report;

    @BeforeClass
    public static void startTest() throws IOException
    {
        String reportPath =
                "src" + File.separator +
                        "main" + File.separator +
                        "resources" + File.separator +
                        "reports" + File.separator +
                        "TestReport.html";
        String configPath =
                "src" + File.separator +
                        "main" + File.separator +
                        "resources" + File.separator +
                        "configs" + File.separator +
                        "extentreports" + File.separator +
                        "spark-config.xml";
        report = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.loadXMLConfig(configPath);
        sparkReporter.config().setReportName("Sample Extent Report");
        report.setSystemInfo("Project", "TDL Summer School");
        report.setSystemInfo("Author", "Alina Rubcova");
        report.attachReporter(sparkReporter);
    }

    @Test(description = "Create new user test")
    private void createUser(){
        ExtentTest test = report.createTest("Create new user test");
        test.log(Status.INFO, "The test is started");

        openUrl();
        HomePage homePage = new HomePage();
        if(homePage.isInitialized())
        {
            test.log(Status.INFO, "Home page is visible");
        }
        else
        {
            test.log(Status.INFO, "Home page is NOT visible");
        }

        homePage.dialogBoxButton.click();
        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage();
        if(dialogBoxesPage.isInitialized())
        {
            test.log(Status.INFO, "Dialog-Boxes button clicked");
        }
        else
        {
            test.log(Status.INFO, "Dialog-Boxes button is NOT clicked");
        }

        dialogBoxesPage.createUserButton.click();

        //TODO Log screenshot with filled fields/output in the console the text each field has

        dialogBoxesPage.createNewUser("test1", "test@test", "test1");

    }

    @AfterClass
    public static void endTest(){
        report.flush();
    }
}
