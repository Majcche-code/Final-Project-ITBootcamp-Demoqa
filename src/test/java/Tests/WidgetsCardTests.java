package Tests;

import Base.BaseTest;
import Pages.CardsPage;
import Pages.DatePickerPage;
import Pages.HomePage;
import Pages.SliderPage;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WidgetsCardTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().setPosition(new Point(1366, 0));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage=new HomePage();
        cardsPage=new CardsPage();
        sliderPage=new SliderPage();
        datePickerPage=new DatePickerPage();

        homePage.clickOnCard("Widgets");

    }
    // !
    @Test(priority = 1)
    public void datePickerIsWorkingProperly() throws InterruptedException {
        cardsPage.clickOnSidebarButton("Date Picker");
        datePickerPage.enterDate();

        Assert.assertFalse(datePickerPage.getSelectDateField.getAttribute("value").isEmpty());
    }

    @Test(priority = 2)
    public void SliderIsWorkingProperly() {
        cardsPage.clickOnSidebarButton("Slider");
        String valueBeforeMove=sliderPage.getSliderValueField.getAttribute("value");
        sliderPage.moveSlider(85);
        String valueAfterMove=sliderPage.getSliderValueField.getAttribute("value");

        Assert.assertNotEquals(valueBeforeMove,valueAfterMove);
    }

    @Test(priority = 3)
    public void dateAndTimePickerWorkingProperly() throws InterruptedException {
        cardsPage.clickOnSidebarButton("Date Picker");
        datePickerPage.enterDateAndTime();

        String actualFieldValue=datePickerPage.getDateAndTimeField.getAttribute("value");
        String expectedFieldValue=datePickerPage.enterDateAndTime();
        Assert.assertEquals(actualFieldValue,expectedFieldValue);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}