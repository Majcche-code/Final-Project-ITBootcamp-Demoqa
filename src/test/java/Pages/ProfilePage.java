package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage extends BaseTest {
    public ProfilePage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="userName-value")
    public WebElement getUserName;

    @FindBy(id="submit")
    public WebElement getLogoutButton;

    @FindBy(css="span[title='Delete']")
    public WebElement getDeleteBookIcon;

    @FindBy(xpath = "//*[@id=\"submit\"]")
    public WebElement getDeleteAccountButton;

    @FindBy(id="closeSmallModal-ok")
    public WebElement getOkDeleteBookButton;

    @FindBy(linkText = "Git Pocket Guide")
    public List<WebElement> getGitPocketGuideBook;

    //-----------------------------------

    public void clickOnDeleteBookIcon(){
        getDeleteBookIcon.click();
    }
    public void clickOnDeleteAccountButton(){
        getDeleteAccountButton.click();
    }
    public void clickOnOKButtonConfirmDeleting(){
        getOkDeleteBookButton.click();
    }
    //provera da li je prisutna knjiga u tabeli
    public boolean addedBookIsPresent(){
        if(getGitPocketGuideBook.isEmpty()){
            return false;
        }
        return true;
    }

}
