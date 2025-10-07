package myapp.tests.listeners;

import myapp.utilities.Driver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static myapp.utilities.WaitUtils.waitFor;
import static org.testng.Assert.assertTrue;

// Here we are learning how to implement Listeners at class level
@Listeners (myapp.utilities.ListenersUtils.class)
public class Day06_ListenerTest {

    /*
    We add Listeners capability for Test methods in two ways:
    1. Through xml files - RECOMMENDED WAY
    2. By using @Listeners annotation in the test class itself
     */


    @Test
    public void listenersTest1(){
        Driver.getDriver().get("https://www.techproeducation.com");
        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);
        assertTrue(title.contains("TechPro Education IT Programs")); // pass
    }

    @Test
    public void listenersTest2(){
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().navigate().refresh();

        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);
        waitFor(3);
        assertTrue(title.contains("Amozon")); // fail
    }

    @Test
    public void listenersTest3(){
        System.out.println("Test 3 is skipped!");
        throw new SkipException("Skipping Test");
    }

    @Test
    public void listenersTest4(){
        Driver.getDriver().get("https://www.google.com");
        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);
        System.out.println("This is Test 4 and this is meant to fail");
        waitFor(3);
        assertTrue(title.contains("TechPro Education"));
    }








}
