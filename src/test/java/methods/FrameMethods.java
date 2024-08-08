package methods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
public class FrameMethods {
    public WebDriver driver;

    public void switchToiFrame(String text) {
        driver.switchTo().frame(text);


    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void defaultContent(){
        driver.switchTo().defaultContent();
    }
}

