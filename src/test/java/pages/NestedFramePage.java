package pages;

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
        System.out.println(text.getText());
    }
}
