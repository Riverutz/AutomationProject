package tests;

import methods.ElementMethods;
import methods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;

import java.util.Arrays;
import java.util.List;

public class WebTableTest {
    public WebDriver driver;

    @Test

    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.navigateToElementsMenu();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.navigateToWebTablesSubMenu();

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.addEntry("Daniel", "Vlasceanu",
                "ps5@yahoo.ro", "33" ,
                "1500", "Testing"
                );
        webTablePage.editEntry("2500", "Programming");
        driver.quit();
    }
}
