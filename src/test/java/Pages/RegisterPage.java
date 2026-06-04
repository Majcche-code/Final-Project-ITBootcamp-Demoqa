package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static TestData.TestData.*;

public class RegisterPage extends BaseTest {

    public RegisterPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "firstname")
    public WebElement getFirstNameField;

    @FindBy(id = "lastname")
    public WebElement getLastNameField;

    @FindBy(id="userName")
    public WebElement getUserNameField;

    @FindBy(id="password")
    public WebElement getPassword;

    @FindBy(id="register")
    public WebElement getRegisterButton;

    //----------------------------------------

    //popunjavanje forme za registraciju novog korisnika podacima iz TestData
    public void fillInRegistrationForm() {
        getFirstNameField.clear();
        getFirstNameField.sendKeys(FIRSTNAME);
        getLastNameField.clear();
        getLastNameField.sendKeys(LASTNAME);
        getUserNameField.clear();
        getUserNameField.sendKeys(USERNAME);
        getPassword.clear();
        getPassword.sendKeys(PASSWORD);
    }
}
