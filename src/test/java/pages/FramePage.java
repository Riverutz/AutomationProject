package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage{
    public FramePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "sampleHeading")
    private WebElement iframeTest;

    @FindBy(id = "sampleHeading")
    private WebElement iframeTestTwo;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement nestedFrames;

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

