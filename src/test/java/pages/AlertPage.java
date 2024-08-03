package pages;

import loggerUtility.LogUtil;
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
        LogUtil.info("The user clicked on alertOK button. ");
        alertMethods.acceptAlert();
        LogUtil.info("The user interacts with the alertOK button successfully. ");
    }
    public void interactWithConfirmationButton(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(alertConfirmButton);
        LogUtil.info("The user clicked on confirmAlert button. ");
        alertMethods.acceptAlert();
        LogUtil.info("The user interacts with the confirmAlert button successfully. ");
    }
    public void interactWithPromptButton(String text){
        elementMethods.clickElement(alertPromptButton);
        LogUtil.info("The user clicked on alertPrompt button. ");
        alertMethods.fillAlert(text);
        LogUtil.info("The user fills the text field with a value. ");
    }
    public void interactWithTimerAlert(){
        elementMethods.clickElement(alertWait);
        LogUtil.info("The user clicked on alertWait button. ");
        alertMethods.acceptAlert();
        LogUtil.info("The user interacts with the alertWait button successfully. ");
    }
}