package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage extends BaseTest {
    public SliderPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="slider")
    public WebElement getSliderHandle;

    @FindBy(id="sliderValue")
    public WebElement getSliderValueField;
    //----------------------------------------

    Actions actions=new Actions(driver);

    //metoda za pomeranje slidera, koja hvata rucku, pomera je po zadatoj X osi
   // i pusta rucku nakon dostizanja zadate vrednosti X ose(u pikselima)
    public void moveSlider(int xOffset){
      actions.clickAndHold(getSliderHandle).moveByOffset(xOffset,0).release().perform();
   }
}
