package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public BookStoreApplicationPage bookStoreApplicationPage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public ProfilePage profilePage;
    public BooksPage booksPage;
    public BookDetailsPage bookDetailsPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
