package tests;

import methods.AlertMethods;
import methods.ElementMethods;
import methods.FrameMethods;
import methods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);
        FrameMethods frameMethods = new FrameMethods(driver);

        pageMethods.scrollPage(0, 350);

        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickElement(alertsMenu);

        WebElement frameForm = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementMethods.clickElement(frameForm);

        //NE MUTAM CU FOCUSUL PE UN iFRAME

        //driver.switchTo().frame("frame1");
        frameMethods.switchToiFrame("frame1");

        WebElement iframeTest = driver.findElement(By.id("sampleHeading"));
        System.out.println(iframeTest.getText());

        //NE INTOARCEM CU FOCUSUL LA FRAME-UL DEFAULT

        //driver.switchTo().defaultContent();
        frameMethods.defaultContent();

        //driver.switchTo().frame("frame2");
        frameMethods.switchToiFrame("frame2");

        WebElement iframeTestTwo = driver.findElement(By.id("sampleHeading"));
        System.out.println(iframeTestTwo.getText());

        //driver.switchTo().defaultContent();
        frameMethods.defaultContent();

        WebElement nestedFrames = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        elementMethods.clickJSElement(nestedFrames);

        //INTERACTIONAM CU iFRAME in iFRAME

        //driver.switchTo().frame("frame1");
        frameMethods.switchToiFrame("frame1");


        WebElement childIFrame = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        //driver.switchTo().frame(childIFrame);
        frameMethods.switchToFrame(childIFrame);

        WebElement text = driver.findElement(By.xpath("//p"));
        System.out.println(text.getText());
    }
}


