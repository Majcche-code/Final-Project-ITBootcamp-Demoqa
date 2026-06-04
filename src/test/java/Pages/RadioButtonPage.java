package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage extends BaseTest {

    public RadioButtonPage()
    { PageFactory.initElements(driver, this);}

    @FindBy(id="yesRadio")
    public WebElement getYesRadioButton;

    @FindBy(className ="mt-3")
    public WebElement getConfirmationMessage;

}
