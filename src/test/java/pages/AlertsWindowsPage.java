package pages;

import loggerUtility.LogUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsWindowsPage extends BasePage{
    public AlertsWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindows;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement frameButton;
    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsForm;

    public void navigateToWindowPage(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(browserWindows);
        LogUtil.info("The user clicks on Browser Windows submenu!");
    }
    public void navigateToFramePage(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(frameButton);
        LogUtil.info("The user clicks on Frames Page!");
    }
    public void navigateToAlertsForm(){
        elementMethods.clickElement(alertsForm);
        LogUtil.info("The user clicks on Alerts form!");
    }
}
