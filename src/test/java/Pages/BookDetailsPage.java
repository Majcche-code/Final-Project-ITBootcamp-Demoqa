package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookDetailsPage extends BaseTest {
    public BookDetailsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="addNewRecordButton")
    public WebElement getAddToYourCollectionButton;

    //---------------------------------------------

public void clickOnAddToYourCollectionButton(){
    getAddToYourCollectionButton.click();
}
}
