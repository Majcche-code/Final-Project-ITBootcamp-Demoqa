package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddingAndDeletingBookTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.manage().window().setPosition(new Point(1366, 0));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/login");

        loginPage=new LoginPage();
        cardsPage=new CardsPage();
        booksPage=new BooksPage();
        bookDetailsPage=new BookDetailsPage();
        homePage=new HomePage();
        profilePage=new ProfilePage();

        loginPage.fillInLoginForm();
        loginPage.getLoginButton.click();
    }
    @Test(priority = 1)
    public void addingBookToCollection() throws InterruptedException {
        cardsPage.clickOnSidebarButton("Book Store");
        Thread.sleep(4000);
        booksPage=new BooksPage();
        booksPage.clickOnGitPocketGuideBook();
        bookDetailsPage = new BookDetailsPage();  //ponovo inicijalizacija
        wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
        bookDetailsPage.clickOnAddToYourCollectionButton();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        cardsPage.clickOnSidebarButton("Profile");

        Assert.assertTrue(profilePage.getDeleteBookIcon.isDisplayed());
        Assert.assertTrue(booksPage.getGitPocketGuideBook.isDisplayed());

    }
    @Test(priority = 2)
    public void deletingABook(){
        profilePage.clickOnDeleteBookIcon();
        profilePage.clickOnOKButtonConfirmDeleting();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        Assert.assertFalse(profilePage.addedBookIsPresent());
    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
}
