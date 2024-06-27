package tests;

import methods.ElementMethods;
import methods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {
    public WebDriver driver;

    @Test

    public void metodaTest() {

        //deschidem un browser
        driver = new ChromeDriver();

        //accesam un anumit URL
        driver.get("https://demoqa.com/");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);


        pageMethods.scrollPage(0,350);

        //interactionam cu meniul/submeniul de pe site
        WebElement elementsmenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementMethods.clickElement(elementsmenu);

        WebElement webTablesubmenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementMethods.clickElement(webTablesubmenu);

        //definim un elementu dupa id

        //Test 1: adaug un entry

        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementMethods.clickElement(addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Daniel";
        //firstNameElement.sendKeys(firstNameValue);
        elementMethods.fillElement(firstNameElement, firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Vlasceanu";
        //lastNameElement.sendKeys(lastNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "ps5@gmail.com";
        //userEmailElement.sendKeys(userEmailValue);
        elementMethods.fillElement(userEmailElement, userEmailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "33";
        //ageElement.sendKeys(ageValue);
        elementMethods.fillElement(ageElement, ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "12500";
        //salaryElement.sendKeys(salaryValue);
        elementMethods.fillElement(salaryElement, salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "Testing";
        //departmentElement.sendKeys(departmentValue);
        elementMethods.fillElement(departmentElement, departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementMethods.clickElement(submitElement);

        //modific un entry existent

        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementMethods.clickElement(editElement);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "2500";
        //editSalaryElement.clear();
        elementMethods.clearFillElement(editSalaryElement, editSalaryValue);
        //editSalaryElement.sendKeys(editSalaryValue);
        //elementMethods.fillElement(editSalaryElement, editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "Programming";
        elementMethods.clearFillElement(editDepartmentElement, editDepartmentValue);
        //departmentElement.sendKeys(departmentValue);
        //elementMethods.fillElement(departmentElement, departmentValue);

    }

}
