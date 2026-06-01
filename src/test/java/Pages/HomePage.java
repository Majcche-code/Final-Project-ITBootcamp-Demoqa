package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest{
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "card-body")
    public List<WebElement> getCards;

    //-------------
    public void clickOnCard(String cardName){
        for(int i=0;i< getCards.size();i++){
            scrollToElement(getCards.get(i));
            if(getCards.get(i).getText().equals(cardName)){
                getCards.get(i).click();
                break;
            }
        }
    }
}
