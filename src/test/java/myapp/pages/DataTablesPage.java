package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataTablesPage {

    public DataTablesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy( xpath = "(//button[@type='button'])[1]")
    public WebElement newButton;

    @FindBy (id = "DTE_Field_first_name")
    public WebElement firstNameInput;

    @FindBy (id = "DTE_Field_last_name")
    public WebElement lastNameInput;

    @FindBy (id = "DTE_Field_position")
    public WebElement positionInput;

    @FindBy (id = "DTE_Field_office")
    public WebElement officeInput;

    @FindBy (id = "DTE_Field_extn")
    public WebElement extensionInput;

    @FindBy (id = "DTE_Field_start_date")
    public WebElement startDateInput;

    @FindBy (id = "DTE_Field_salary")
    public WebElement salaryInput;

    @FindBy (xpath = "//button[@class='btn']")
    public WebElement createButton;

    @FindBy (xpath = "//input[@type='search']")
    public WebElement searchBox;

    @FindBy (xpath = "(//td[@class='sorting_1'])[1]")
    public WebElement nameField;




}