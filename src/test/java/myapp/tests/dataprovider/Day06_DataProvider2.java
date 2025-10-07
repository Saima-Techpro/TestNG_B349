package myapp.tests.dataprovider;

import myapp.pages.DataTablesPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.DataProviderUtils;
import myapp.utilities.Driver;
import myapp.utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static myapp.utilities.WaitUtils.waitFor;
import static org.testng.Assert.assertTrue;

public class Day06_DataProvider2 {

    /*
When user go to https://editor.datatables.net/
Click on the new button
When user enters all fields
When user clicks on ‘create’ button
And search for the first name
Then verify the name field contains first name

   */
    protected WebDriver driver;
    DataTablesPage dataTablesPage;
    ExcelUtils excelUtils;
    List<Map<String, String>> dataList;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        //When user go to https://editor.datatables.net/
        driver.get(ConfigReader.getProperty("dataTables_url"));
        dataTablesPage = new DataTablesPage();

    }

    @Test ( dataProvider = "userData" , dataProviderClass = DataProviderUtils.class)
    public void loginTestWithDataProvider(
            String firstName ,
            String lastName ,
            String position,
            String office,
            String extension,
            String startDate,
            String salary){

//        Click on the new button
        dataTablesPage.newButton.click();

//        When user enters all fields
        dataTablesPage.firstNameInput.sendKeys(firstName);
        dataTablesPage.lastNameInput.sendKeys(lastName);
        dataTablesPage.positionInput.sendKeys(position);
        dataTablesPage.officeInput.sendKeys(office);
        dataTablesPage.extensionInput.sendKeys(extension);
        dataTablesPage.startDateInput.sendKeys(startDate);
        dataTablesPage.salaryInput.sendKeys(salary);
        waitFor(2);

//        When user clicks on ‘create’ button
        dataTablesPage.createButton.click();
        waitFor(2);

//        And search for the first name
        dataTablesPage.searchBox.sendKeys(firstName);
        waitFor(2);
//        Then verify the name field contains first name
        assertTrue(dataTablesPage.nameField.getText().contains(firstName));


    }

    @AfterMethod
    public void tearDown(){
        waitFor(3);
        Driver.closeDriver();
    }


}
