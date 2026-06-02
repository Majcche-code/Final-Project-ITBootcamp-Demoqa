package Tests;

import Base.BaseTest;
import Pages.CardsPage;
import Pages.HomePage;
import Pages.TextBoxFormPage;
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

public class TextBoxTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().setPosition(new Point(1366, 0));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com");

        homePage=new HomePage();
        cardsPage=new CardsPage();
        textBoxFormPage=new TextBoxFormPage();
    }
    @Test
    public void TextBoxFormWorkingProperly()  {
        homePage.clickOnCard("Elements");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("router-link")));
        //wait.until(ExpectedConditions.elementToBeClickable(By.className("router-link")));
        cardsPage.clickOnSidebarButton("Text Box");
        textBoxFormPage.fillInTextBoxForm();
        textBoxFormPage.getSubmitButton.click();

        Assert.assertTrue(textBoxFormPage.getOutputMessage.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
