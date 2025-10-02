package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static myapp.utilities.WaitUtils.waitFor;

public class OrangeHRM_HomePage {

    public OrangeHRM_HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h6")
    public WebElement dashboardHeader;

    @FindBy (css = "li.oxd-userdropdown")
    public WebElement profileDropdown;

    @FindBy (linkText = "Logout")
    public WebElement logoutOption;

    public void logout(){
        profileDropdown.click();
        waitFor(1);
        logoutOption.click();
    }


}





