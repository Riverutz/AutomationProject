package pages;

import methods.ElementMethods;
import methods.FrameMethods;
import methods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramePage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public FrameMethods frameMethods;

    public NestedFramePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        frameMethods = new FrameMethods(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    public WebElement childIFrame;

    @FindBy(xpath = "//p")
    public WebElement text;

    public void interactWithNestedFrame(){

        frameMethods.switchToFrame(childIFrame);
        System.out.println(text.getText());

    }
}
