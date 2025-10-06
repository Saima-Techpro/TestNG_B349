package myapp.tests.excelautomation;

import myapp.pages.DataTablesPage;
import myapp.utilities.Driver;

import myapp.utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import static myapp.utilities.WaitUtils.waitFor;
import static org.testng.Assert.assertTrue;

public class Day05_LoginTestWithExcel {
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
    List<Map <String, String>> dataList;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        //When user go to https://editor.datatables.net/
        driver.get("https://editor.datatables.net/");
        dataTablesPage = new DataTablesPage();

    }

    @Test
    public void loginTestWithExcel(){

        String pathOfFile = "./resources/data_sheet.xlsx";
        excelUtils = new ExcelUtils(pathOfFile, "user_data");

        // getDataList()  method from ExcelUtils class returns a List of Map and that the
        // internal structure of the map is key:value pair where both key and value are of String data type
        dataList =  excelUtils.getDataList();
        System.out.println(dataList);

        // To get each data at the cell level
//        for (Map<String, String> eachData : dataList){
//            System.out.println(eachData.get("first_name"));
//            System.out.println(eachData.get("last_name"));
//            System.out.println(eachData.get("position"));
//        }

        for (Map<String, String> eachData : dataList){

            //Click on the new button
        dataTablesPage.newButton.click();
        //When user enters all fields
        dataTablesPage.firstNameInput.sendKeys(eachData.get("first_name"));
        dataTablesPage.lastNameInput.sendKeys(eachData.get("last_name"));
        dataTablesPage.positionInput.sendKeys(eachData.get("position"));
        dataTablesPage.officeInput.sendKeys(eachData.get("office"));
        dataTablesPage.extensionInput.sendKeys(eachData.get("extension"));
        dataTablesPage.startDateInput.sendKeys(eachData.get("start_date"));
        dataTablesPage.salaryInput.sendKeys(eachData.get("salary"));
        waitFor(2);
        //When user clicks on ‘create’ button
        dataTablesPage.createButton.click();
        // NOTE: Test was failing because of synchronisation issue, not the locator
        // So we added wait to give the DOM time to settle so the elements are available

        waitFor(2);
        //And search for the first name
        dataTablesPage.searchBox.sendKeys(eachData.get("first_name"));
        waitFor(2);
        //Then verify the name field contains first name
        assertTrue(dataTablesPage.nameField.getText().contains(eachData.get("first_name")));
        waitFor(2);
        dataTablesPage.searchBox.clear();
        waitFor(2);

        }


    }

    @AfterMethod
    public void tearDown(){
        waitFor(3);
        Driver.closeDriver();
    }
}
