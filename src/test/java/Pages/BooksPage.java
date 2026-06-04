package Pages;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BooksPage extends BaseTest {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public BooksPage() {
        PageFactory.initElements(driver, this);
    }

   @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/span/a")
   public WebElement getGitPocketGuideBook;

    //-------------------------------------------

    public void clickOnGitPocketGuideBook(){
        scrollToElement(getGitPocketGuideBook);
        wait.until(ExpectedConditions.elementToBeClickable(getGitPocketGuideBook));
        getGitPocketGuideBook.sendKeys(Keys.ENTER);
    }

}
