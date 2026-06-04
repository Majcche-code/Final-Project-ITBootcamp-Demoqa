package Tests;

import Base.BaseTest;
import Pages.AlertsFrameWindowsPage;
import Pages.CardsPage;
import Pages.HomePage;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsFrameWindowCardTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().setPosition(new Point(1366, 0));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage=new HomePage();
        alertsFrameWindowsPage=new AlertsFrameWindowsPage();
        cardsPage=new CardsPage();
    }

    @Test (priority = 1)
    public void newTabButtonWorkingProperly(){
        homePage.clickOnCard("Alerts, Frame & Windows");
        cardsPage.clickOnSidebarButton("Browser Windows");
        alertsFrameWindowsPage.clickOnNewTabButton();

        Assert.assertEquals(driver.getWindowHandles().size(),2);

    }

    @Test(priority = 2)
    public void newWindowButtonWorkingProperly(){
        homePage.clickOnCard("Alerts, Frame & Windows");
        cardsPage.clickOnSidebarButton("Browser Windows");
        int widowsBeforeClick=driver.getWindowHandles().size();
        alertsFrameWindowsPage.clickOnNewWindowButton();
        int windowsAfterClick=driver.getWindowHandles().size();

        Assert.assertTrue(widowsBeforeClick<windowsAfterClick);
    }

    @Test(priority = 3)
    public void NewWindowMessageWorkingProperly(){
        homePage.clickOnCard("Alerts, Frame & Windows");
        cardsPage.clickOnSidebarButton("Browser Windows");
        alertsFrameWindowsPage.clickOnNewWindowMessageButton();

        Assert.assertEquals(driver.getWindowHandles().size(),2);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
