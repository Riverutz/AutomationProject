package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{
    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement alertButtonOK;

    @FindBy(id="confirmButton")
    private  WebElement alertConfirmButton;

    @FindBy(id="promtButton")
    private WebElement alertPromptButton;

    @FindBy(id="timerAlertButton")
    private WebElement alertWait;

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