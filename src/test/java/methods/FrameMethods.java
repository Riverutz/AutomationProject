package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods {
    public WebDriver driver;

    public FrameMethods(WebDriver driver) {
        this.driver = driver;
    }

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

