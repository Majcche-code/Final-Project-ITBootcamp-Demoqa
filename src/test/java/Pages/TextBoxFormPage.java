package Pages;

import Base.BaseTest;
import TestData.TestData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBoxFormPage extends BaseTest {
   // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public TextBoxFormPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "userName")
    public WebElement getFullNameField;

    @FindBy(id = "userEmail")
    public WebElement getEmailField;

    @FindBy(id = "currentAddress")
    public WebElement getCurrentAddressField;

    @FindBy(id = "permanentAddress")
    public WebElement getPermanentAddressField;

    @FindBy(id="submit")
    public WebElement getSubmitButton;

    @FindBy(id="output")
    public WebElement getOutputMessage;

    //--------------------------------------------------

    public void fillInTextBoxForm(){
        getFullNameField.clear();
        getFullNameField.sendKeys(TestData.FULLNAME);
        getEmailField.clear();
        getEmailField.sendKeys(TestData.EMAIL);
        getCurrentAddressField.clear();
        getCurrentAddressField.sendKeys(TestData.CURRENTADDRESS);
        getPermanentAddressField.clear();
        getPermanentAddressField.sendKeys(TestData.PERMANENTADDRESS);

    }


}
