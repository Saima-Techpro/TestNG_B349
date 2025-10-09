package myapp.tests.extentreports;

import myapp.pages.OrangeHRM_HomePage;
import myapp.pages.OrangeHRM_LoginPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.ExtentReportUtils;
import myapp.utilities.LoggerUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static myapp.utilities.WaitUtils.waitFor;
import static myapp.utilities.WaitUtils.waitForVisibility;
import static org.testng.Assert.assertTrue;

public class Day07_OrangeHRM_LoginTestWithExtentReports {

    /*
    When user navigates to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login homepage
    And User enters Username
    And User enters password
    And User clicks on Login button
    Verify the login is successful
    And User logs out
    Verify the logout is successful

     */

    protected WebDriver driver;
    // Create OrangeHRM_HomePage object to reach out to the elements located in that class
    OrangeHRM_LoginPage orangeHRMLoginPage;
    OrangeHRM_HomePage orangeHRMHomePage;


    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        // Initiate the page object inside the test method
        orangeHRMLoginPage = new OrangeHRM_LoginPage();
        orangeHRMHomePage = new OrangeHRM_HomePage();

        // If you want to use Loggers too
        LoggerUtils.info("Starting the test!");

        // To start the report creating: MANDATORY STEP
        ExtentReportUtils.createTestReport("Testing Login Feature", "Testing login for Smoke Suite");


        ExtentReportUtils.info("User is navigating to the website");
        // When user navigates to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login homepage
        driver.get(ConfigReader.getProperty("orangehrm_url"));
        waitFor(2);
        ExtentReportUtils.passAndCaptureScreenshot("Navigation is successful!");
    }

    @Test
    public void orangeHRMLoginTest1(){

//        And User enters Username
        orangeHRMLoginPage.usernameInput.sendKeys(ConfigReader.getProperty("orangehrm_username"));
        waitFor(1);
        ExtentReportUtils.pass("Username is successfully entered");

//        And User enters password
        orangeHRMLoginPage.passwordInput.sendKeys(ConfigReader.getProperty("orangehrm_password"));
        waitFor(1);
        ExtentReportUtils.pass("Password is entered successfully");

//        And User clicks on Login button
        orangeHRMLoginPage.loginButton.click();
        waitForVisibility(orangeHRMHomePage.dashboardHeader, 5);
        ExtentReportUtils.passAndCaptureScreenshot("User clicks on login button");

//        Verify the login is successful
        assertTrue(orangeHRMHomePage.dashboardHeader.isDisplayed());
        // OR
        assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
        waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("Login is successful!");
//        And User logs out
        orangeHRMHomePage.profileDropdown.click();
        waitFor(2);
        orangeHRMHomePage.logoutOption.click();
        waitFor(2);
        ExtentReportUtils.pass("User clicks on logout button");

//        Verify the logout is successful
        assertTrue(orangeHRMLoginPage.loginHeader.isDisplayed());
        waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("Logout is successful!");

        // To make sure, the report is generated, use flush() : MANDATORY STEP
        ExtentReportUtils.flush();

        LoggerUtils.info("Test completed!");

    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing the driver");
        Driver.closeDriver();
    }


}
