package myapp.tests.excelautomation;

import myapp.pages.DataTablesPage;
import myapp.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static myapp.utilities.WaitUtils.waitFor;
import static org.testng.Assert.assertTrue;

public class Day05_LoginTest {

    protected WebDriver driver;
    DataTablesPage dataTablesPage;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        //When user go to https://editor.datatables.net/
        driver.get("https://editor.datatables.net/");

        dataTablesPage = new DataTablesPage();

    }

    @Test
    public void loginTestWithoutExcel(){
//Click on the new button
        dataTablesPage.newButton.click();
//When user enters all fields
        dataTablesPage.firstNameInput.sendKeys("Ali");
        dataTablesPage.lastNameInput.sendKeys("Can");
        dataTablesPage.positionInput.sendKeys("QA Analyst");
        dataTablesPage.officeInput.sendKeys("New York");
        dataTablesPage.extensionInput.sendKeys("12345");
        dataTablesPage.startDateInput.sendKeys("2025-10-06");
        dataTablesPage.salaryInput.sendKeys("80000");
//When user clicks on ‘create’ button
        dataTablesPage.createButton.click();
        // NOTE: Test was failing because of synchronisation issue, not the locator
        // So we added wait to give the DOM time to settle so the elements are available

        waitFor(1);
//And search for the first name
        dataTablesPage.searchBox.sendKeys("Ali");
        waitFor(1);
//Then verify the name field contains first name
        assertTrue(dataTablesPage.nameField.getText().contains("Ali"));

    }

    @AfterMethod
    public void tearDown(){
        waitFor(3);
        Driver.closeDriver();
    }
}
