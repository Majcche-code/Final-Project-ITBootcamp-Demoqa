package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookDetailsPage extends BaseTest {
    public BookDetailsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add To Your Collection')]")
    public WebElement getAddToYourCollectionButton;

    //---------------------------------------------

    //problem da nadje element AddToYour collection svaki put
    //id , class isti i za dugme iznad
public void clickOnAddToYourCollectionButton(){
    getAddToYourCollectionButton.click();
}
}
