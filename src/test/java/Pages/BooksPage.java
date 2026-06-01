package Pages;

import Base.BaseTest;
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

   @FindBy(linkText = "Git Pocket Guide")
   public WebElement getGitPocketGuideBook;

    //-------------------------------------------

    public void clickOnGitPocketGuideBook(){
        scrollToElement(getGitPocketGuideBook);
        wait.until(ExpectedConditions.elementToBeClickable(getGitPocketGuideBook));
        getGitPocketGuideBook.click();
    }

}
