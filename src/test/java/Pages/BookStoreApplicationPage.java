package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookStoreApplicationPage extends BaseTest {
    WebDriver driver;
  //  WebElement bookStoreApplicationCard;
    List<WebElement>bookStoreSideBar;

    public BookStoreApplicationPage(WebDriver driver){
        this.driver=driver;
    }

    public List<WebElement> getBookStoreSideBar() {
        return driver.findElements(By.className("router-link"));
    }

   // public WebElement getBookStoreApplicationCard() {
     //   return bookStoreApplicationCard;
   // }

    //---------
    public void clickOnSideBarOption(String optionName){
        for(int i=0;i<getBookStoreSideBar().size();i++){
            scrollToElement(getBookStoreSideBar().get(i));
            if(getBookStoreSideBar().get(i).getText().equals(optionName)){
                getBookStoreSideBar().get(i).click();
                break;
            }
        }

    }


}
