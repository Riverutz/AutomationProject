package methods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@AllArgsConstructor
public class AlertMethods {
    public WebDriver driver;

    //DEFINIM METODE GENERALE PENTRU INTERACTIUNEA CU ALERTE
    public void waitForAlert(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.alertIsPresent());

    }
    public void acceptAlert(){
        waitForAlert();
        Alert waitConfirm = driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.accept();
    }
    public void dismissAlert(){
        waitForAlert();
        Alert waitConfirm = driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.dismiss();

    }
    public void fillAlert(String value){
        Alert promptConfirm = driver.switchTo().alert();
        System.out.println(promptConfirm.getText());
        promptConfirm.sendKeys(value);
        promptConfirm.accept();
    }
}

