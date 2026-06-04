package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsFrameWindowsPage extends BaseTest {
    public AlertsFrameWindowsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="tabButton")
    public WebElement getNewTabButton;

    @FindBy(id="windowButton")
    public WebElement getNewWindowButton;

    @FindBy(id="messageWindowButton")
    public WebElement getNewWindowMessageButton;

    //--------------------------

    public void clickOnNewTabButton(){
        getNewTabButton.click();
    }
    public void clickOnNewWindowButton(){
        getNewWindowButton.click();
    }
    public void clickOnNewWindowMessageButton(){
        getNewWindowMessageButton.click();
    }

}
