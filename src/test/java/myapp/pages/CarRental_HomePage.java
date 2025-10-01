package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CarRental_HomePage {
    // We create constructor and use PageFactory to initialise the elements

    public CarRental_HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    /*
    SYNTAX of finding elements in Junit => driver.findElement()
    SYNTAX of finding elements in TestNG =>
    @FindBy ( locator )
    public WebElement loginButton;

     */


    @FindBy (linkText = "Login/Register")
    public WebElement loginOption;

    @FindBy (name = "email")
    public WebElement emailInput;

    @FindBy (name = "password")
    public WebElement passwordInput;

    @FindBy( css = "button[type='submit']")
    public WebElement loginButton;

    @FindBy (xpath = "(//a[@role='button'])[1]")
    public WebElement profileDropdown;



}
