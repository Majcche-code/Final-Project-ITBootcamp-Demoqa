package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectablePage extends BaseTest {
    public SelectablePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mt-2.list-group-item.list-group-item-action")
    public WebElement getFirstField;
}
