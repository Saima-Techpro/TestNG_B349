package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day01_DependsOnMethods {

    // DependsOnMethods parameter is used to make the tests dependent on each other
    // If the test (on which other tests depend on) fails, dependent tests will be skipped

    @Test
    public void homePageTest(){
        System.out.println("Home Page test... ");
        Assert.assertTrue(true);

    }

    @Test (dependsOnMethods = "homePageTest")
    public void searchTest(){
        System.out.println("Searching a book ... ");
        Assert.assertTrue(false);
    }

    @Test (dependsOnMethods = "searchTest")
    public void checkoutTest(){
        System.out.println("Checking out to pay for the book.... ");

    }



}
