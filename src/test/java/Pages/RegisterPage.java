package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    WebDriver driver;
    WebElement firstName;
    WebElement lastName;
    WebElement userName;
    WebElement password;
    WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getFirstName() {
        return firstName;
    }
    //--------
    public void fillInRegistrationForm(){
        getFirstName().clear();
        getFirstName().sendKeys("Maja");
        getLastName().clear();
        getLastName().sendKeys("Dumitrov");
        getUserName().clear();
        getUserName().sendKeys();

    }
}
