package pages;

import methods.ElementMethods;
import methods.PageMethods;
import methods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public WindowMethods windowMethods;

    public HomePage(WebDriver driver){
    this.driver=driver;
        elementMethods = new ElementMethods(driver);
        windowMethods = new WindowMethods(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }
    //WebElement subMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertMenu;

    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement formsMenu;

    public void navigateToAlertsMenu(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(alertMenu);

    }
    public void navigateToFormsMenu(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(formsMenu);
    }
}
