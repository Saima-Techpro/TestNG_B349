package myapp.tests.dataprovider;

import myapp.utilities.DataProviderUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day05_DataProvider1 {


    // DataProvider method works with 2D Array
    // We don't need LOOPS to pass all data sets
    // DataProvider annotation ensures that all data sets are provided from that method inside the test method

    @DataProvider
    public Object[][] productListProvider(){
        Object[][] products = { {"Toyota"}, {"Tesla"} , {"Volvo"} , {"BYD"} , {"BMW"}};
        return products;
    }

    @DataProvider (name = "employee_credentials")
    public Object[][] credentialProvider(){
        Object[][] credentialsList = {
                {"admin1" , "pass1" , "CEO" , "52"} ,
                {"admin2" , "pass2" , "SDET" , "42"} ,
                {"admin3" , "pass3" , "PM" , "38"} ,
                {"admin4" , "pass4" , "QA" , "30"}
        };
        return credentialsList;
    }



    @Test (dataProvider = "productListProvider")
    public void productTest(String data){
        System.out.println(data);
    }

    // NOTE: This won't be work anymore AFTER using a name attribute for the above method
    // If name attribute is used for any dataProvider method, then we MUST call it by that name
//    @Test (dataProvider = "credentialProvider")
//    public void employeeTest(String userName , String password , String title , String age){
//        System.out.println("Username: " +  userName + " | Password: " + password + " | Title: " +title +" | Age: " +age);
//    }




    @Test (dataProvider = "employee_credentials")
    public void employeeTest(String userName , String password , String title , String age){
        System.out.println("Username: " +  userName + " | Password: " + password + " | Title: " +title +" | Age: " +age);
    }


    // This test method is going to get the data from a method which is in a different class from utilities package
    @Test (dataProvider = "employeeCredentialsProvider" , dataProviderClass = DataProviderUtils.class)
    public void test(String email , String pass ){
        System.out.println("Email: " +  email + " | Password: " + pass);
    }





}
