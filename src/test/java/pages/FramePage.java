package pages;

import methods.ElementMethods;
import methods.FrameMethods;
import methods.PageMethods;
import methods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public FrameMethods frameMethods;

    public FramePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        frameMethods = new FrameMethods(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "sampleHeading")
    public WebElement iframeTest;

    @FindBy(id = "sampleHeading")
    public WebElement iframeTestTwo;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    public WebElement nestedFrames;


    public void interactWithBigIframe() {
        pageMethods.scrollPage(0, 350);
        frameMethods.switchToiFrame("frame1");
        System.out.println(iframeTest.getText());
        frameMethods.defaultContent();
    }

    public void interactWithSmallIframe() {
        pageMethods.scrollPage(0, 350);
        frameMethods.switchToiFrame("frame2");
        System.out.println(iframeTest.getText());
        frameMethods.defaultContent();

    }

    public void navigateToNestedFrames() {
        elementMethods.clickJSElement(nestedFrames); //pagescroll de pus in caz ca nu merge testu
        frameMethods.switchToiFrame("frame1");
    }
}

