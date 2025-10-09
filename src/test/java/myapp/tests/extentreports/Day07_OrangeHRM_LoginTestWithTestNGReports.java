package myapp.tests.extentreports;

import myapp.pages.OrangeHRM_HomePage;
import myapp.pages.OrangeHRM_LoginPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static myapp.utilities.BrowserUtils.verifyElementDisplayed;
import static myapp.utilities.WaitUtils.waitFor;
import static myapp.utilities.WaitUtils.waitForVisibility;
import static org.testng.Assert.assertTrue;

public class Day07_OrangeHRM_LoginTestWithTestNGReports {


    /*
    NOTES about TesTNG Reports:
    1. Created this class
    2. Generated testng.xml file using 'Create XML file' plugin by right-clicking on the class
    3. Renamed it reports.xml file
    4. From the top menu, click on Run button > edit configurations
    5. A new window open up, make sure reports.xml is visible and selected
    6. Click on Listeners and add 4 listeners
    7. Apply and OK
    8. Run the test again from reports.xml file
    9. A new report should be available in test-output folder
    10. Open the reports in browser
     */


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

        // When user navigates to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login homepage
        driver.get(ConfigReader.getProperty("orangehrm_url"));
    }

    @Test
    public void orangeHRMLoginTest1(){

//        And User enters Username
        orangeHRMLoginPage.usernameInput.sendKeys(ConfigReader.getProperty("orangehrm_username"));

//        And User enters password
        orangeHRMLoginPage.passwordInput.sendKeys(ConfigReader.getProperty("orangehrm_password"));

//        And User clicks on Login button
        orangeHRMLoginPage.loginButton.click();
        waitForVisibility(orangeHRMHomePage.dashboardHeader, 5);

//        Verify the login is successful
        assertTrue(orangeHRMHomePage.dashboardHeader.isDisplayed());
        // OR
        assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
//        And User logs out
        orangeHRMHomePage.profileDropdown.click();
        waitFor(2);
        orangeHRMHomePage.logoutOption.click();
        waitFor(2);

//        Verify the logout is successful
        assertTrue(orangeHRMLoginPage.loginHeader.isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing the driver");
        Driver.closeDriver();
    }


}
