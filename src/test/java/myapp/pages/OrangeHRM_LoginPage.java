package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static myapp.utilities.WaitUtils.waitFor;

public class OrangeHRM_LoginPage {

    // 1. Create constructor
    // 2. Initialise the elements through PageFactory
    // 3. Locate elements using @FindBy annotation

    public OrangeHRM_LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy( name = "username")
    public WebElement usernameInput;

    @FindBy( name = "password")
    public WebElement passwordInput;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy (xpath = "//h5")
    public WebElement loginHeader;

    // Reusable Login method
    public void login(String username, String pass){
        waitFor(1);
        usernameInput.sendKeys(username);
        waitFor(1);
        passwordInput.sendKeys(pass);
        waitFor(1);
        loginButton.click();

    }



}
