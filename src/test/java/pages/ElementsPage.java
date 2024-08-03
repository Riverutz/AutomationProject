package pages;

import loggerUtility.LogUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage{
    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webTables;

    public void navigateToWebTablesSubMenu() {
        pageMethods.scrollPage(0, 350);
        LogUtil.info("The user scrolled down the page!");
        elementMethods.clickElement(webTables);
        LogUtil.info("The user clicked on Web Tables submenu!");
    }
}
