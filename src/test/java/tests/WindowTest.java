package tests;

import methods.ElementMethods;
import methods.PageMethods;
import methods.WindowMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        //DEFINIM UN OBIECT DE TIPUL WINDOW METHODS
        WindowMethods windowMethods = new WindowMethods(driver);
        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);

        pageMethods.scrollPage(0,350);

        WebElement alertMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickElement(alertMenu);

        WebElement subMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementMethods.clickElement(subMenu);

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        elementMethods.clickElement(newTabButton);

        //INTERACTIONAM CU UN TAB/WINDOW
        System.out.println(driver.getCurrentUrl()); //URL-ul PAGINII CURENTE PE CARE NE AFLAM
        //List<String> tabs = new ArrayList<>(driver.getWindowHandles()); //GASESTE CATE TABURI/WINDOWS SUNT DESCHISE IN MOMEMENTUL DEFINIRII
        //NE MUTAM CU FOCUSUL PE UN ANUMIT TAB
        //driver.switchTo().window(tabs.get(1));
        //ce am scris mai sus, de la 'interactionam cu un tab, este acelasi procedeu in orice framework am lucra noi pe parte de web. Toate functioneaza la fel,

        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());

        //inchidem tab-ul curent
        //driver.close();
        windowMethods.closeCurrentTab();

        //REDIRECTIONAM FOCUSUL PE UN ALT TAB DUPA CE IL INCHIDE PE CEL ANTERIOR
        //driver.switchTo().window(tabs.get(0)); //prima varianta
        windowMethods.switchSpecificTab(0);

        WebElement newWindow = driver.findElement(By.id("windowButton"));
        elementMethods.clickElement(newWindow);
        System.out.println(driver.getCurrentUrl());

        //List<String> window = new ArrayList<>(driver.getWindowHandles());
        //driver.switchTo().window(window.get(1));
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());

        //driver.close();
        windowMethods.closeCurrentTab();
        driver.quit();

    }
}

