import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import java.io.File;
import java.io.IOException;

public class Task1 extends TestBase {

    //TODO netiek izmantots
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

    @Test(description = "Create new user test - Test 1")
    private void createUserTest1() {
        ExtentTest test = report.createTest("Create new user test - Test 1");
        test.log(Status.INFO, "Test 1 started");

        openUrl();
        HomePage homePage = new HomePage();

        if (homePage.isInitialized()) {
            test.log(Status.INFO, "Home page is visible");
        } else {
            test.log(Status.INFO, "Home page is NOT visible");
        }

        homePage.dialogBoxButton.click();

        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage();
        if (dialogBoxesPage.isInitialized()) {
            test.log(Status.INFO, "DialogBoxes button cicked sucsessfulland DialogBoxes Page is visable");
        } else {
            test.log(Status.INFO, "DialogBoxes Page  is NOT visible");
        }
        AddsPage addsPage = new AddsPage();
        if (addsPage.addsCloseButton.isButtonPresent()) {
            addsPage.closeAdd();
            test.log(Status.INFO, "Add poped out, and was closed sucsessfully");
        }

        if (dialogBoxesPage.isInitialized()) {
            test.log(Status.INFO, "'Create User' button is visible");
            //dialogBoxesPage.clickCreateUserButton(); vai
            dialogBoxesPage.createUserButton.click();// Nestrādā- iframe problēmas

            // Get the values from the form fields before entering new values
            String nameBefore = dialogBoxesPage.name.getValue();
            String emailBefore = dialogBoxesPage.email.getValue();
            String passwordBefore = dialogBoxesPage.password.getValue();

            // Log the values to the console
            System.out.println("Before entering new values:");
            System.out.println("Name: " + nameBefore);
            System.out.println("Email: " + emailBefore);
            System.out.println("Password: " + passwordBefore);

            // Enter your own values into the form fields
            dialogBoxesPage.name.enterTextValue("Test1");
            dialogBoxesPage.email.enterTextValue("test1@test.com");
            dialogBoxesPage.password.enterTextValue("test1");

            // Log the new values to the console
            System.out.println("After entering new values:");

            //TODO turinājums šeit

            closeDriver();
        } else {
            test.log(Status.INFO, "'Create User' button is NOT visible");
        }
        closeDriver();
    }

    @Test(description = "Tabs test, open section 2")
    private void tabsTest() {
        ExtentTest test2 = report.createTest("Tabs test, open section 2");
        test2.log(Status.INFO, "Test 2 started");

        openUrl();
        HomePage homePage = new HomePage();

        if (homePage.isInitialized()) {
            test2.log(Status.INFO, "Home page is visible");
        } else {
            test2.log(Status.INFO, "Home page is NOT visible");
        }

        homePage.tabsButton.click();

        TabsPage tabsPage = new TabsPage();
        AddsPage addsPage = new AddsPage();
        if(addsPage.addsCloseButton.isButtonPresent()){
            test2.log(Status.INFO, "Add poped out and Add was closed");
            addsPage.closeAdd();
        }
        else {
            test2.log(Status.INFO, "No adds poped out");
        }

        if(tabsPage.section2Button.isButtonPresent()){
            test2.log(Status.INFO, "Tabs button clicked and Tabs page is visible");
        }
        else {
            test2.log(Status.INFO, "Tabs page is NOT visible");
        }

        tabsPage.section2Button.click();
        //4.Validate that the Section 2 is open/expanded and the text of the section is visible
        //5. Log screenshot/output in the console the text of the section

        closeDriver();
    }

    @Test(description = "Testing progress bar" )
    private void ProgressBarTest(){
        ExtentTest test3 = report.createTest("ProgressBar test ");
        test3.log(Status.INFO, "Test 3 started");

        openUrl();
        HomePage homePage = new HomePage();

        if (homePage.isInitialized()) {
            test3.log(Status.INFO, "Home page is visible");
        } else {
            test3.log(Status.INFO, "Home page is NOT visible");
        }

        homePage.progressBarButton.click();
        if(homePage.progressBarButton.isButtonPresent()){
            test3.log(Status.INFO, "Progress Bar button was clicked and ProgressBar Page is visible");
        }
        else {
            test3.log(Status.INFO, "ProgressBar Page is NOT visible");
        }

        ProgressBarPage progressBarPage = new ProgressBarPage();

        progressBarPage.randomProgressBarrButton.click();
        if (progressBarPage.randomColorButton.isButtonPresent()){
            test3.log(Status.INFO, "Random Progress Bar button was clicked sucsesfully");
        }
        else {
            test3.log(Status.INFO, "Random Progress Bar button was NOT clicked sucsesfully");
        }

        /*List<WebElement> iframes = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div[1]/div/div[2]/p/iframe"));
        if (iframes.size() > 0) {
            WebElement iframe = iframes.get(0);
            driver.switchTo().frame(iframe);

           progressBarPage.randomColorButton.click();

            // Pēc tam iziet no <iframe>
            driver.switchTo().defaultContent();
        } else {
            System.out.println("Iframe netika atrasts");
        }
        */

        //4. Click on button [Random Color]
        progressBarPage.randomColorButton.click();//nenostrada jo ir iframe

        //5. Click on button [Random Value - Determinate]
        //6. Log screenshot/output in the console the value(percentage) of the progress
        //bar, and the rgb value of the color
        //*Create a method that converts the rgb value of the color in a color name and
        //outputs that in the console instead, example: “Color of the progress bar: red

        closeDriver();
    }

    @Test(description = "Testing message box" )
    private void messagBoxTesting(){
        ExtentTest test4 = report.createTest("Testing message box");
        test4.log(Status.INFO, "Test 4started");

        //1. Open page 'https://www.globalsqa.com/demo-site/'
        openUrl();
        HomePage homePage = new HomePage();

        if (homePage.isInitialized()) {
            test4.log(Status.INFO, "Home page is visible");
        } else {
            test4.log(Status.INFO, "Home page is NOT visible");
        }

        //2. Click on button [DialogBox]
        homePage.dialogBoxButton.click();

        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage();
        if (dialogBoxesPage.isInitialized()) {
            test4.log(Status.INFO, "DialogBoxes Page is visable");
        } else {
            test4.log(Status.INFO, "DialogBoxes Page  is NOT visible");
        }

        //3. Click on tab [MESSAGE BOX]
        dialogBoxesPage.messageBoxButton.click();

        //4. In the 'Download complete' message box, click on button [OK]
        //5. Validate that the [Message box] is no longer displayed
        //6. Click on tab [FORM]
        //7. Click on tab [MESSAGE BOX]
        //8. Validate that the [Message box] is no longer displayed

        closeDriver();
    }

    @Test(description = "Testing Search Field" )
    private void searcTesting(){
        ExtentTest test5 = report.createTest("Testing Search Field - Test 5");
        test5.log(Status.INFO, "Test 5 started");
        //1. Open page'https://www.globalsqa.com/demo-site/auto-complete/'
        openAutoCompleteUrl();

        //2. In field ‘Search’ fill in phrase ‘and'
        //3. In dropdown menu select value'anders andersson'
        //4. Log a screenshot/output in the console the selected value

        closeDriver();
    }

    @AfterClass
    public static void endTest(){
        report.flush();
    }
}
