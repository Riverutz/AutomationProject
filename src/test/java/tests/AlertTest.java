package tests;

import methods.AlertMethods;
import methods.ElementMethods;
import methods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        //WAIT IMPLICIT
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //DEFINIM UN OBIECT DE TIP ALERT METHODS CA SA APELAM METODELE GENERALE DIN CLASA
        AlertMethods alertMethods = new AlertMethods(driver);
        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);

        pageMethods.scrollPage(0, 350);

        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickElement(alertsMenu);

        WebElement alertsForm = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementMethods.clickElement(alertsForm);

        //interactionam cu o alerta
        pageMethods.scrollPage(0, 350);

        WebElement alertButtonOK = driver.findElement(By.id("alertButton"));
        elementMethods.clickElement(alertButtonOK);


        alertMethods.acceptAlert();

/*
        Alert alertOK = driver.switchTo().alert();
        System.out.println(alertOK.getText());
        alertOK.accept();

 */

        pageMethods.scrollPage(0, 350);
        WebElement alertConfirmButton = driver.findElement(By.id("confirmButton"));
        elementMethods.clickElement(alertConfirmButton);


        alertMethods.dismissAlert();
/*
        Alert alertConfirm = driver.switchTo().alert();
        System.out.println(alertConfirm.getText());
        alertConfirm.dismiss();

 */

        WebElement alertPromptButton = driver.findElement(By.id("promtButton"));
        elementMethods.clickElement(alertPromptButton);


        alertMethods.fillAlert("Daniel");
/*
        Alert promptConfirm = driver.switchTo().alert();
        System.out.println(promptConfirm.getText());
        String alertValue = "Daniel";
        promptConfirm.sendKeys(alertValue);
        promptConfirm.accept();

 */

        //Interactionam cu o alerta pentru care trebuie sa asteptam putin
        WebElement alertWait = driver.findElement(By.id("timerAlertButton"));
        elementMethods.clickElement(alertWait);


        alertMethods.acceptAlert();
/*
        //Definim un wait explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.alertIsPresent());

        Alert waitConfirm = driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.accept();

 */

    }
}


