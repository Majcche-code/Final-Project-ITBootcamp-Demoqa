package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.awt.*;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public CardsPage cardsPage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public ProfilePage profilePage;
    public BooksPage booksPage;
    public BookDetailsPage bookDetailsPage;
    public TextBoxFormPage textBoxFormPage;
    public RadioButtonPage radioButtonPage;
    public AlertsFrameWindowsPage alertsFrameWindowsPage;
    public SliderPage sliderPage;
    public DatePickerPage datePickerPage;
    public SelectablePage selectablePage;

    @BeforeClass
    public void setUp(){

        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();

        GraphicsDevice[] screens = ge.getScreenDevices();

        for (GraphicsDevice screen : screens) {
            Rectangle bounds =
                    screen.getDefaultConfiguration().getBounds();

            System.out.println(bounds);
        }

        WebDriverManager.chromedriver().setup();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
