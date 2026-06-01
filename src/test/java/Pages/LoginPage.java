package Pages;

import Base.BaseTest;
import TestData.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static TestData.TestData.PASSWORD;
import static TestData.TestData.USERNAME;

public class LoginPage extends BaseTest {

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "newUser")
    public WebElement getNewUserButton;

    @FindBy(id="userName")
    public WebElement getUserNameField;

    @FindBy(id="password")
    public WebElement getPasswordField;

    @FindBy(id="login")
    public WebElement getLoginButton;

    //-----------
    public void clickOnNewUserButton(){
       getNewUserButton.click();
    }
    public void fillInLoginForm(){
        getUserNameField.clear();
        getUserNameField.sendKeys(USERNAME);
        getPasswordField.clear();
        getPasswordField.sendKeys(PASSWORD);


    }
}
