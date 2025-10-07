package myapp.tests.topics;

import myapp.pages.CarRental_HomePage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.annotations.Test;

import static myapp.utilities.WaitUtils.waitForVisibility;
import static org.testng.Assert.assertEquals;

public class Day03_CarRentalTest {

     /*
    When user navigates to https://www.speedyli.com/ homepage
    Then User clicks on login option
    And User enters email address
    And User enters password
    And User clicks on Login button
    Verify the login in successful

//Car Rental Credentials
//carRental_email=ceyhancan@cars.com
//carRental_password=Aa1234567!


     */
    // Create the object of the page class so that we can reach to the web elements that we located and stored there
    CarRental_HomePage carRentalHomePage;

    @Test (groups = "Regression Test")
    public void carRentalTest1(){
        carRentalHomePage = new CarRental_HomePage();

//        When user navigates to https://www.speedyli.com/ homepage
        Driver.getDriver().get("https://www.speedyli.com/");

//        Then User clicks on login option
        carRentalHomePage.loginOption.click();

//        And User enters email address
        carRentalHomePage.emailInput.sendKeys("ceyhancan@cars.com");

//        And User enters password
        carRentalHomePage.passwordInput.sendKeys("Aa1234567!");

//        And User clicks on Login button
        carRentalHomePage.loginButton.click();

//        Verify the login in successful
        waitForVisibility(carRentalHomePage.profileDropdown, 5);

        String dropdownText = carRentalHomePage.profileDropdown.getText();

        assertEquals("a a", dropdownText);

        Driver.closeDriver();

    }



    @Test
    public void carRentalTest2(){
        carRentalHomePage = new CarRental_HomePage();

//        When user navigates to https://www.speedyli.com/ homepage
        Driver.getDriver().get(ConfigReader.getProperty("carRental_url"));

//        Then User clicks on login option
        carRentalHomePage.loginOption.click();

//        And User enters email address
        carRentalHomePage.emailInput.sendKeys(ConfigReader.getProperty("carRental_email"));

//        And User enters password
        carRentalHomePage.passwordInput.sendKeys(ConfigReader.getProperty("carRental_password"));

//        And User clicks on Login button
        carRentalHomePage.loginButton.click();

//        Verify the login in successful
        waitForVisibility(carRentalHomePage.profileDropdown, 5);
        String dropdownText = carRentalHomePage.profileDropdown.getText();
        assertEquals("a a", dropdownText);

        Driver.closeDriver();

    }


}


