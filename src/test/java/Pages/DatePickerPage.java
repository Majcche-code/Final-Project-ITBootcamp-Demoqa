package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

public class DatePickerPage extends BaseTest {
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    public DatePickerPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="datePickerMonthYearInput")
    public WebElement getSelectDateField;

    @FindBy(id="dateAndTimePickerInput")
    public WebElement getDateAndTimeField;

    //------------------------------------
    // biranje nasumicnog datuma i satnice
    Random random=new Random();
    int day= random.nextInt(28)+1;
    int monthNumber= random.nextInt(12)+1;
    int year= random.nextInt(2026-2000+1)+2000;

    String monthName= Month.of(random.nextInt(12)+1).getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    int hour=random.nextInt(12);
    int minute=random.nextInt(60);
    String partOfDay=random.nextBoolean()?"AM":"PM";

    // smestanje u promenljivu
    String date=monthNumber+"/"+day+"/"+year;
    String dateAndTime=monthName+" "+day+", "+year+" "+hour+":"+minute+" "+partOfDay;

    // pisanje datuma u polju
    public void enterDate() throws InterruptedException {
        scrollToElement(getSelectDateField);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datePickerMonthYearInput")));
        wait.until(ExpectedConditions.elementToBeClickable(getSelectDateField));

        getSelectDateField.click();

        //sigurniji nacin za brisanje sadrzaja polja, clear() nije radio
        getSelectDateField.sendKeys(Keys.CONTROL + "a");
        getSelectDateField.sendKeys(Keys.DELETE);

        getSelectDateField.sendKeys(date);
        getSelectDateField.sendKeys(Keys.ENTER);
    }

    // metoda koja vraca nasumicno izbranu vrednost za datum i vreme, radi koriscenja u asertaciji kasnije
    public String enterDateAndTime() throws InterruptedException {

        scrollToElement(getSelectDateField);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateAndTimePickerInput")));
        wait.until(ExpectedConditions.elementToBeClickable(getDateAndTimeField));

        getDateAndTimeField.click();
        getDateAndTimeField.sendKeys(Keys.CONTROL + "a");
        getDateAndTimeField.sendKeys(Keys.DELETE);
        getDateAndTimeField.sendKeys(dateAndTime);

        return dateAndTime;
    }
}
