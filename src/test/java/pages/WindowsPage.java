package pages;

import loggerUtility.LogUtil;
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
        LogUtil.info("The user scrolled down the page!");
        elementMethods.clickElement(newTab);
        LogUtil.info("The user clicked on new tab button.");

        System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);
        LogUtil.info("The user switched on another tab.");
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurrentTab();
        LogUtil.info("The user has closed the current tab.");
        windowMethods.switchSpecificTab(0);
        LogUtil.info("The user switched back on the default tab.");

    }

    public void interactWithWindow(){
        pageMethods.scrollPage(0, 350);
        LogUtil.info("The user scrolled down the page!");
        elementMethods.clickElement(newWindow);
        LogUtil.info("The user clicked on new window button.");
        System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);
        LogUtil.info("The user switched on another tab.");
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurrentTab();
        LogUtil.info("The user has closed the current tab.");
    }
}
