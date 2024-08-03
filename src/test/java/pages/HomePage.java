package pages;

import loggerUtility.LogUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertMenu;

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsMenu;

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;

    public void navigateToAlertsMenu(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(alertMenu);
        LogUtil.info("The user clicks on Alerts Menu!");

    }
    public void navigateToFormsMenu(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(formsMenu);
        LogUtil.info("The user clicks on Forms Menu!");
    }
    public void navigateToElementsMenu(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(elementsMenu);
        LogUtil.info("The user clicks on Elements Menu!");
    }
}
