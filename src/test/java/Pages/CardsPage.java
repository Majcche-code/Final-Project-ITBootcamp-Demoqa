package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CardsPage extends BaseTest {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public CardsPage() {
    PageFactory.initElements(driver, this);
}
    @FindBy(className = "router-link")
    public List<WebElement> getSidebarOptions;

    //---------------------

    public void clickOnSidebarButton(String buttonName){
        for(WebElement element:getSidebarOptions){
            if(element.getText().equals(buttonName)){
                scrollToElement(element);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                break;
            }
        }
    }



/*
    public void clickOnSidebarButton(String buttonName) {
        for (int i = 0; i < getSidebarOptions.size(); i++) {
            scrollToElement(getSidebarOptions.get(i));
            if (getSidebarOptions.get(i).getText().equals(buttonName)) {
                getSidebarOptions.get(i).click();
                break;
            }
        }
    }*/

/*
    //---------
    public void clickOnLoginButton(){
        scrollToElement(getLoginButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        System.out.println(getLoginButton.isDisplayed());
        getLoginButton.click();


    }

*/

}
