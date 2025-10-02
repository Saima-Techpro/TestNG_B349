package myapp.tests.smoketests;

import myapp.pages.OrangeHRM_HomePage;
import myapp.pages.OrangeHRM_LoginPage;
import myapp.utilities.Driver;
import org.testng.annotations.Test;

import static myapp.utilities.WaitUtils.waitFor;
import static myapp.utilities.WaitUtils.waitForVisibility;
import static org.testng.Assert.assertTrue;

public class Day04_OrangeHRM_LoginTest {

    /*
    When user navigates to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login homepage
    And User enters Username
    And User enters password
    And User clicks on Login button
    Verify the login is successful
    And User logs out
    Verify the logout is successful

     */

    // Create OrangeHRM_HomePage object to reach out to the elements located in that class
    OrangeHRM_LoginPage orangeHRMLoginPage;
    OrangeHRM_HomePage orangeHRMHomePage;



    @Test
    public void orangeHRMLoginTest(){

        // Initiate the page object inside the test method
        orangeHRMLoginPage = new OrangeHRM_LoginPage();
        orangeHRMHomePage = new OrangeHRM_HomePage();

//        When user navigates to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login homepage
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//        And User enters Username
        orangeHRMLoginPage.usernameInput.sendKeys("Admin");

//        And User enters password
        orangeHRMLoginPage.passwordInput.sendKeys("admin123");

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


}
