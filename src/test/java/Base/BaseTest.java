package Base;

import Pages.BookStoreApplicationPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;
    public BookStoreApplicationPage bookStoreApplicationPage;
    public LoginPage loginPage;
    public RegisterPage registerPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
