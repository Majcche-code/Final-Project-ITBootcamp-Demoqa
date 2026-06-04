package Tests;

import Base.BaseTest;
import Pages.CardsPage;
import Pages.HomePage;
import Pages.SelectablePage;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class InteractionsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().setPosition(new Point(1366, 0));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com");

        selectablePage=new SelectablePage();
        homePage=new HomePage();
        cardsPage=new CardsPage();

        homePage.clickOnCard("Interactions");
    }
    @Test
    public void selectFromSelectableCard() throws InterruptedException {
        cardsPage.clickOnSidebarButton("Selectable");
        selectablePage.getFirstField.click();

        //u promenljivoj smestam atribut elementa
        String classes=selectablePage.getFirstField.getAttribute("class");

        // provera tacnosti da atribut sadrzi rec active, sto znaci da je polje aktivno-selektovano
        Assert.assertTrue(classes.contains("active"));
        selectablePage.getFirstField.click();

        //Assert.assertFalse(classes.contains("active"));  //ideja za proveru da nije aktivno polje-ne radi

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
