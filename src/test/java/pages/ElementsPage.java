package pages;

import methods.ElementMethods;
import methods.PageMethods;
import methods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public WindowMethods windowMethods;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        windowMethods = new WindowMethods(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    public WebElement webTables;

    public void navigateToWebTablesSubMenu() {
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(webTables);

    }
}
