package pages;

import loggerUtility.LogUtil;
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
        LogUtil.info("The user switched to a specific frame. ");
        System.out.println(iframeTest.getText());
        LogUtil.info("The user interacts with an element inside the frame. ");
        frameMethods.defaultContent();
        LogUtil.info("The user switched to primary frame. ");
    }

    public void interactWithSmallIframe() {
        pageMethods.scrollPage(0, 350);
        frameMethods.switchToiFrame("frame2");
        LogUtil.info("The user switched to a specific frame. ");
        System.out.println(iframeTest.getText());
        LogUtil.info("The user interacts with an element inside the frame. ");
        frameMethods.defaultContent();
        LogUtil.info("The user switched to primary frame. ");

    }

    public void navigateToNestedFrames() {
        elementMethods.clickJSElement(nestedFrames);
        LogUtil.info("The user interacts with a nested frame. ");
        frameMethods.switchToiFrame("frame1");
        LogUtil.info("The user switched to a specific frame. ");
    }
}

