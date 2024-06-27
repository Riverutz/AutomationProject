package pages;

import methods.AlertMethods;
import methods.ElementMethods;
import methods.FrameMethods;
import methods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public FrameMethods frameMethods;
    public AlertMethods alertMethods;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        alertMethods = new AlertMethods(driver);
        pageMethods = new PageMethods(driver);

        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "alertButton")
    public WebElement alertButtonOK;

    @FindBy(id="confirmButton")
    public  WebElement alertConfirmButton;

    @FindBy(id="promtButton")
    public WebElement alertPromptButton;

    @FindBy(id="timerAlertButton")
    public WebElement alertWait;

    public void interactAlertOK(){
        elementMethods.clickElement(alertButtonOK);
        alertMethods.acceptAlert();
    }
    public void interactWithConfirmationButton(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(alertConfirmButton);
        alertMethods.acceptAlert();
    }
    public void interactWithPromptButton(String text){
        elementMethods.clickElement(alertPromptButton);
        alertMethods.fillAlert(text);
    }
    public void interactWithTimerAlert(){
        elementMethods.clickElement(alertWait);
        alertMethods.acceptAlert();
    }
}