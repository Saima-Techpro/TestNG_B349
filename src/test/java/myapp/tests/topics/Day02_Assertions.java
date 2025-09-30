package myapp.tests.topics;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class Day02_Assertions {

    @Test
    public void hardAssertTest(){
        // NOTE: HARD ASSERTION means that system stops execution immediately if assertion fails at ANY point
        System.out.println("Checking how hard assertion works....");
        assertEquals(12, 12);
        System.out.println("Printing line 14..... ");
        assertTrue("Selenium".contains("e"));
        System.out.println("Printing line 16..... ");
        assertEquals("Java", "java"); // this assertion fails ... HARD ASSERTION
        System.out.println("Printing line 17..... "); // This and all the following lines of codes will NOT be executed because of HARD ASSERTION
        assertFalse("Java".contains("S"));

    }

    @Test
    public void javaAssertTest(){
        // NOTE: Java assertion also acts like HARD ASSERTION
        assert 3 < 5;
        System.out.println("Printing line 28..... ");
        assert "Apple".contains("p");
        System.out.println("Printing line 30..... ");
        assert "Selenium".toLowerCase().startsWith("s");
        System.out.println("Printing line 32..... ");
        assert "Java" == "java"; // assertion fails at this line so next line is not executed => acts like HARD ASSERTION
        System.out.println("Printing line 34..... ");
    }

    @Test
    public void softAssertTest(){

        /*
        How to use Soft Assertion in TestNG?
        1. Create an object from SoftAssert class
        2. Use this object wherever you need it
        3. Use assertAll() as a last step (MANDATORY)
         */

        System.out.println("Checking how Soft assertion works....");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Java", "java"); // This assertion fails
        System.out.println("Printing line 52..... ");
        softAssert.assertTrue("Selenium".contains("S"));
        System.out.println("Printing line 54..... ");
        softAssert.assertTrue("Java".contains("S")); // This assertion fails
        System.out.println("Printing line 56..... ");
        softAssert.assertTrue("Apple".contains("p"));
        System.out.println("Printing line 58..... ");
        softAssert.assertAll();

    }

    /*
    In JUNIT, we only have HARD ASSERTION

    HARD ASSERTION: If assertion fails, it stops executing the rest of the test and throws exception straightaway.

    In TestNG, we have two types of assertions:
    1. HARD ASSERTION: it works the same way as in JUNIT
    2. Soft ASSERTION: It is different in a sense that it doesn't stop executing the test if assertion fails at any point
                       rather, it carries on until the last step and shows in end where assertion failed.
                       But it won't work without assertAll() in the end.

                       assertAll() is MANDATORY.

     */


}
