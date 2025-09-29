package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day01_DependsOnGroups {

    // groups = is used to declare that a test belongs to a particular group
    // dependsOnGroups is a parameter that is used to make a test dependent on a particular group

    @Test (groups = "Smoke Test")
    public void homePageTest(){
        System.out.println("Home Page test... ");
        Assert.assertTrue(false);

    }

    @Test (groups = "Regression Test")
    public void searchTest(){
        System.out.println("Searching a book ... ");
        Assert.assertTrue(true);
    }

    @Test (dependsOnGroups = "Smoke Test")
    public void paymentTest(){
        System.out.println("Going to pay for the book.... ");

    }

    @Test (dependsOnGroups = "Regression Test")
    public void logoutTest(){
        System.out.println("Logging out after the payment.... ");

    }
}
