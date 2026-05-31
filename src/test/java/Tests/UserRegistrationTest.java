package Tests;

import Base.BaseTest;
import Pages.BookStoreApplicationPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class UserRegistrationTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        homePage=new HomePage(driver);
        bookStoreApplicationPage=new BookStoreApplicationPage(driver);
        loginPage=new LoginPage(driver);
        registerPage=new RegisterPage(driver);
    }
}
