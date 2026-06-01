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
    public WebElement firstNameField;

    @FindBy(id = "lastname")
    public WebElement lastNameField;

    @FindBy(id="userName")
    public WebElement userNameField;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="register")
    public WebElement registerButton;

    //----------------

    public void fillInRegistrationForm(){
        firstNameField.clear();
        firstNameField.sendKeys(FIRSTNAME);
        lastNameField.clear();
        lastNameField.sendKeys(LASTNAME);
        userNameField.clear();
        userNameField.sendKeys(USERNAME);
        password.clear();
        password.sendKeys(PASSWORD);
    }
}
