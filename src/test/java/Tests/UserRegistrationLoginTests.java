package Tests;

import Base.BaseTest;
import Pages.*;
import TestData.TestData;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserRegistrationLoginTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().setPosition(new Point(1366, 0));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage=new HomePage();
       // booksPage=new BooksPage();
        cardsPage=new CardsPage();
        loginPage=new LoginPage();
        registerPage=new RegisterPage();
        profilePage=new ProfilePage();

        homePage.clickOnCard("Book Store Application");

    }
    /*
    @Test
    public void UserRegistration() throws InterruptedException {
        cardsPage.clickOnSidebarButton("Login");
        loginPage.clickOnNewUserButton();
        registerPage.fillInRegistrationForm();
        registerPage.getRegisterButton.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
    // Ne prolazi registracija zbog reCaptcha provere, nalog kreiram rucno
*/
    @Test(priority=1)
    public void LoginWithValidCredentials(){
        cardsPage.clickOnSidebarButton("Login");
        loginPage.fillInLoginForm();
        System.out.println(loginPage.getPasswordField.getAttribute("value"));

        loginPage.getLoginButton.click();
        wait.until(ExpectedConditions.visibilityOf(profilePage.getUserName));

        Assert.assertEquals(profilePage.getUserName.getText(), TestData.USERNAME);
        Assert.assertTrue(profilePage.getLogoutButton.isDisplayed());
    }
    @Test (priority=2)
    public void userCanNotLoginWithInvalidPassword(){
        cardsPage.clickOnSidebarButton("Login");
        loginPage.getUserNameField.sendKeys(TestData.USERNAME);
        loginPage.getPasswordField.sendKeys("123123.!");
        loginPage.getLoginButton.click();

        Assert.assertTrue(loginPage.getErrorMessage.isDisplayed());
        Assert.assertTrue(loginPage.getErrorMessage.getText().equals("Invalid username or password!"));
        Assert.assertTrue(loginPage.getLoginButton.isDisplayed());

    }
    @Test(priority = 3)

    public void userCanDeleteAccount() {
        cardsPage.clickOnSidebarButton("Login");
        loginPage.fillInLoginForm();
        loginPage.getLoginButton.click();
        profilePage.clickOnDeleteAccountButton();

        Assert.assertTrue(loginPage.getLoginButton.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
