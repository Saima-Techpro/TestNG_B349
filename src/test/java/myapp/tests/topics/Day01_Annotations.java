package myapp.tests.topics;

import org.testng.annotations.*;

public class Day01_Annotations {

       /*

    @Test : the most commonly used annotation - works the same way in TestNG as in JUnit

    Hierarchy in TestNG : suite > test > group > class > method

    @Before and @After : there are 5 sets of  @Before and @After in TestNG

    In TestNG, we have can set priority, we can enable, disable or ignore test methods using these annotations:

    (priority = 3)      => run the test method on 3rd number
    @Ignore             => ignore that test method => test doesn't get executed , doesn't show pass/fail , marks the test as ignored/skipped
    (enabled = false)   => method won't run => completely disable, test doesn't get executed , it is not reported either =>
                            = > it makes the test behave as if it doesn't even exist in the test class

    NOTE: If there's a method with no priority mentioned, that will run FIRST.
          If there are more one such methods, they'll be run in alphabetical order.

    By default, tests run from top to bottom  .. following ascending / alphabetical order
    So if we want to run any particular test first, we have the option to mention priority for that test case

    @Test(priority = 3) will run this test case at number 3.
    We can also use negative numbers; but that's not common and recommended

    We can also group tests together by passing group = "name of the group" in @Test parameter to run all tests under one group
    and mentioning that group name in @BeforeGroup and @AfterGroup method

     */

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite.... ");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before groups... ");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test.... ");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class.... ");

    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method.... ");
    }





    @Test (priority = 3)
    public void test01(){
        System.out.println("Test case 1.... ");
    }

    @Test (priority = 5 , groups = "Smoke Test")
    public void test02(){
        System.out.println("Test case 2.... ");
    }

    @Test (priority = 2 , enabled = false)
    public void test03(){
        System.out.println("Test case 3.... ");
    }


    @Test (priority = 6 , groups = "Smoke Test")
    public void test04(){
        System.out.println("Test case 4.... ");
    }

    // NOTE: Any test that does not have priority set, will always be executed first.
    @Test
    public void test05(){
        System.out.println("Test case 5.... ");
    }

    @Ignore
    @Test (priority = 1 )
    public void test06(){
        System.out.println("Test case 6.... ");
    }




    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite.... ");
    }

    @AfterGroups
    public void afterGroups(){
        System.out.println("After groups... ");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test.... ");
    }

    @AfterSuite
    public void afterClass(){
        System.out.println("After class.... ");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method.... ");
    }






}
