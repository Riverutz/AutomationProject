package pages;

import methods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected ElementMethods elementMethods;
    protected PageMethods pageMethods;
    protected FrameMethods frameMethods;
    protected AlertMethods alertMethods;
    protected WindowMethods windowMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        frameMethods = new FrameMethods(driver);
        alertMethods = new AlertMethods(driver);
        windowMethods = new WindowMethods(driver);
        PageFactory.initElements(driver, this);
    }
}
