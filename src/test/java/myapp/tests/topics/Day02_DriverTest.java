package myapp.tests.topics;

import myapp.utilities.Driver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class Day02_DriverTest {

    @Test
    public void driverTest() throws InterruptedException {

        // driver.get("https://www.google.com"); in JUnit
        // In TestNG, Driver.getDriver() returns the driver
        Driver.getDriver().get("https://www.google.com");

        assertTrue(Driver.getDriver().getTitle().contains("Google"));
        Thread.sleep(2000);

        Driver.closeDriver();


    }

}
