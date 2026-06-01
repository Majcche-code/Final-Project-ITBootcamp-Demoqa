package Tests;

import Base.BaseTest;
import Pages.*;
import TestData.TestData;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserRegistrationTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage=new HomePage();
        bookStoreApplicationPage=new BookStoreApplicationPage();
        loginPage=new LoginPage();
        registerPage=new RegisterPage();
        profilePage=new ProfilePage();

        homePage.clickOnCard("Book Store Application");

    }
    @Test (priority = 1)
    public void UserRegistration(){
       // bookStoreApplicationPage.getLoginButton.click();

        loginPage.clickOnNewUserButton();
        registerPage.fillInRegistrationForm();
        registerPage.registerButton.click();
        driver.navigate().refresh();
    }
    @Test(priority=2)
    public void LoginWithValidCredentials(){
        bookStoreApplicationPage.clickOnSidebarButton("Login");
       // bookStoreApplicationPage.clickOnLoginButton();
        loginPage.fillInLoginForm();
        loginPage.getLoginButton.click();
       // driver.navigate().refresh();

        Assert.assertEquals(profilePage.getUserName.getText(), TestData.USERNAME);
        Assert.assertTrue(profilePage.getLogoutButton.isDisplayed());

    }

    @BeforeMethod
    public void tearDown(){
       // driver.quit();
    }
}
