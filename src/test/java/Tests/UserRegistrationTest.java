package Tests;

import Base.BaseTest;
import Pages.*;
import TestData.TestData;
import org.openqa.selenium.Point;
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
        driver.manage().window().setPosition(new Point(1366, 0));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage=new HomePage();
        cardsPage=new CardsPage();
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
        cardsPage.clickOnSidebarButton("Login");
        loginPage.fillInLoginForm();
        loginPage.getLoginButton.click();

       // Assert.assertEquals(profilePage.getUserName.getText(), TestData.USERNAME);
       // Assert.assertTrue(profilePage.getLogoutButton.isDisplayed());
    }
    @Test (priority=3)
    public void userCanNotLoginWithInvalidPassword(){
        cardsPage.clickOnSidebarButton("Login");
        loginPage.getUserNameField.sendKeys(TestData.USERNAME);
        loginPage.getPasswordField.sendKeys("123123.!");
        loginPage.getLoginButton.click();

        Assert.assertTrue(loginPage.getErrorMessage.isDisplayed());
        Assert.assertTrue(loginPage.getErrorMessage.getText().equals("Invalid username or password!"));
        Assert.assertTrue(loginPage.getLoginButton.isDisplayed());

    }
    @Test
    public void userCanDeleteAccount(){
        cardsPage.clickOnSidebarButton("Login");
        loginPage.fillInLoginForm();
        loginPage.getLoginButton.click();
        profilePage.clickOnDeleteAccountButton();

        Assert.assertTrue(loginPage.getLoginButton.isDisplayed());
    }

    @BeforeMethod
    public void tearDown(){
       // driver.quit();
    }
}
