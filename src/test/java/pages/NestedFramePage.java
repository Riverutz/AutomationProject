package pages;

import loggerUtility.LogUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramePage extends BasePage{
    public NestedFramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    private WebElement childIFrame;
    @FindBy(xpath = "//p")
    private WebElement text;

    public void interactWithNestedFrame(){
        frameMethods.switchToFrame(childIFrame);
        LogUtil.info("The user switched to a child frame. ");
        System.out.println(text.getText());
        LogUtil.info("The user interacts with an element inside the child frame. ");
    }
}
