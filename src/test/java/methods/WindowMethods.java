package methods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethods {

    public WebDriver driver;

    public WindowMethods(WebDriver driver) {
        this.driver = driver;
    }

    //METODE GENERALE PENTRU INTERACTIUNEA CU TAB/WINDOW

    public void switchSpecificTab(Integer index){

        List<String> window = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(window.get(index));

    }
    public void closeCurrentTab(){
        driver.close();
    }

}

