package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsCardPage extends BaseTest {

    public FormsCardPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="firstName")
    public WebElement getFirstNamefield;

    @FindBy(id="lastName")
    public WebElement getLastNameField;

    @FindBy(id="userEmail")
    public WebElement getEmailField;

    @FindBy(id="gender-radio-2")
    public WebElement getGenderFemaleButton;

    @FindBy(id="userNumber")
    public WebElement getUserNumberField;

    @FindBy(id="dateOfBirthInput")
    public WebElement getDateOfBirth;



}
