package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage{
    WebDriver driver;
    WebElement newUserButton;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getNewUserButton() {
        return driver.findElement(By.id("newUser"));
    }
    //-----------
    public void clickOnNewUserButton(){
        getNewUserButton().click();
    }
}
