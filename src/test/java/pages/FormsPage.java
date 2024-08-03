package pages;

import loggerUtility.LogUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends BasePage{
    public FormsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceForm;

    public void navigateToPracticeForm() {
        elementMethods.clickElement(practiceForm);
        LogUtil.info("The user clicks on Practice Form submenu!");
    }
}
