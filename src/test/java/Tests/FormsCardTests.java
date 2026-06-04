package Tests;

import Base.BaseTest;
import Pages.CardsPage;
import Pages.HomePage;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormsCardTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().setPosition(new Point(1366, 0));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com");

        homePage=new HomePage();
        cardsPage=new CardsPage();

    }
    @Test
    public void practiceFormIsWorkingProperly(){
        homePage.clickOnCard("Forms");
        cardsPage.clickOnSidebarButton("Practice Form");
// nije zavrseno


    }
    @BeforeMethod
    public void tearDown(){
      //  driver.quit();
    }
}