package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage {
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTab;

    @FindBy(id = "windowButton")
    private WebElement newWindow;

    public void interactWithNewTab() {
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(newTab);

        System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurrentTab();
        windowMethods.switchSpecificTab(0);

    }
    public  void interactWithWindow(){
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(newWindow);

        System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurrentTab();
    }
}
