package pages;

import methods.AlertMethods;
import methods.ElementMethods;
import methods.FrameMethods;
import methods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public FrameMethods frameMethods;
    public AlertMethods alertMethods;

    public FormsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        alertMethods = new AlertMethods(driver);
        pageMethods = new PageMethods(driver);

        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='Practice Form']")
    public WebElement practiceForm;

    public void navigateToPracticeForm(){
        elementMethods.clickElement(practiceForm);
    }

}
