package tests;

import methods.ElementMethods;
import methods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {
    public WebDriver driver;


    @Test
    public void metodaTest() {

        //deschidem un browser
        driver = new ChromeDriver();

        //accesam un anumit URL
        driver.get("https://demoqa.com");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        //OBIECTE
        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);


        //facem un scroll la pagina pentru vizibilitate
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);

        //interactionam cu meniul/submeniul de pe site
        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementMethods.clickElement(formsMenu);

        //interactionam cu meniul/submeniul de pe site
        WebElement practiceForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementMethods.clickElement(practiceForm);

        WebElement firstName = driver.findElement(By.id("firstName"));
        String firstNameValue = "Daniel Alexandru";
        //firstName.sendKeys(firstNameValue);
        elementMethods.fillElement(firstName, firstNameValue);

        WebElement lastName = driver.findElement(By.id("lastName"));
        String lastNameValue = "Vlasceanu";
        //lastName.sendKeys(lastNameValue);
        elementMethods.fillElement(lastName, lastNameValue);

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        String userEmailValue = "ps5@yahoo.ro";
        //userEmail.sendKeys(userEmailValue);
        elementMethods.fillElement(userEmail, userEmailValue);

        pageMethods.scrollPage(0,350);

        //definim o logica generala de a selecta un element dintr-o lista
        List<WebElement> genderElements = driver.findElements(By.xpath("//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']"));
        String genderValue = "Male";
        switch (genderValue) {
            case "Male":
                //genderElements.get(0).click();
                elementMethods.clickElement(genderElements.get(0));
                break;
            case "Female":
                //genderElements.get(1).click();
                elementMethods.clickElement(genderElements.get(1));
                break;
            case "Other":
                //genderElements.get(2).click();
                elementMethods.clickElement(genderElements.get(2));
                break;
        }

        WebElement userNumber = driver.findElement(By.id("userNumber"));
        String userNumberValue = "0741223451";
        //userNumber.sendKeys(userNumberValue);
        elementMethods.fillElement(userNumber, userNumberValue);

        //DATE OF BIRTH

        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        elementMethods.clickElement(dateOfBirth);

        WebElement dateOfBirthMonth = driver.findElement(By.className("react-datepicker__month-select"));
        //Select monthSelect = new Select(dateOfBirthMonth);
        // monthSelect.selectByVisibleText("September");
        elementMethods.selectByTextElement(dateOfBirthMonth, "September");


        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        //Select yearSelect = new Select(year);
        //yearSelect.selectByVisibleText("1990");
        elementMethods.selectByValue(year, "1990");

        //div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']

        List<WebElement> dateOfBirthDays = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']"));
        String dateOfBirthDaysValue = "23";
        for (Integer index = 0; index<dateOfBirthDays.size(); index++){
            if (dateOfBirthDays.get(index).getText().equals(dateOfBirthDaysValue)){
                //dateOfBirthDays.get(index).click();
                elementMethods.clickElement(dateOfBirthDays.get(index));
                break;
            }
        }

        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        String subjectsInputValue = "Arts";
        //subjectsInput.sendKeys(subjectsInputValue);
        elementMethods.fillElement(subjectsInput, subjectsInputValue);
        //subjectsInput.sendKeys(Keys.ENTER);
        elementMethods.pressElement(subjectsInput, Keys.ENTER);

        List<WebElement> hobbiesElements = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']"));
        List<String> hobbiesValues = Arrays.asList("Sports", "Reading", "Music");
        for (Integer index = 0; index < hobbiesElements.size(); index++) {
            String hobbyText = hobbiesElements.get(index).getText();
            if (hobbiesValues.contains(hobbyText)) {
                //JavascriptExecutor executor = (JavascriptExecutor) driver;
                // executor.executeScript("arguments[0].click();", hobbiesElements.get(index));
                elementMethods.clickJSElement(hobbiesElements.get(index));
            }
        }

        //interactionam cu un fisier

        WebElement uploadPictureElement = driver.findElement(By.id("uploadPicture"));
        String picturePathValue = "sample.txt";
        File file = new File("src/test/resources/" + picturePathValue);
        uploadPictureElement.sendKeys(file.getAbsolutePath());

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "Str. Hohoho";
        //currentAddress.sendKeys(currentAddressValue);
        elementMethods.fillElement(currentAddress, currentAddressValue);

        pageMethods.scrollPage(0,350);

        WebElement state = driver.findElement(By.id("state"));
        elementMethods.clickElement(state);

        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        String stateElementValue = "Uttar Pradesh";
        //stateElement.sendKeys(stateElementValue);
        elementMethods.fillElement(stateElement, stateElementValue);
        //stateElement.sendKeys(Keys.ENTER);
        elementMethods.pressElement(stateElement, Keys.ENTER);

        WebElement city = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Agra";
        //city.sendKeys(cityValue);
        elementMethods.fillElement(city, cityValue);
        //city.sendKeys(Keys.ENTER);
        elementMethods.pressElement(city, Keys.ENTER);

        pageMethods.scrollPage(0,350);

        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        elementMethods.clickElement(submit);

        //validam valorile introduse

        WebElement thankYouMessage = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankYouMessage.getText(),"Thanks for submitting the form");
        List<WebElement> tableValues = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
        Assert.assertEquals(tableValues.get(0).getText(),"Student Name " + firstNameValue + " " + lastNameValue);
        Assert.assertEquals(tableValues.get(1).getText(),"Student Email " + userEmailValue);
        Assert.assertEquals(tableValues.get(2).getText(),"Gender " + genderValue);
        Assert.assertEquals(tableValues.get(3).getText(),"Mobile " + userNumberValue);
        Assert.assertEquals(tableValues.get(5).getText(),"Subjects " + subjectsInputValue);
        String expectedHobbiesText = "Hobbies " + String.join(", ", hobbiesValues);
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);
        Assert.assertEquals(tableValues.get(7).getText(),"Picture " + picturePathValue );
        Assert.assertEquals(tableValues.get(8).getText(),"Address " + currentAddressValue);
        Assert.assertEquals(tableValues.get(9).getText(),"State and City " + stateElementValue + " " +cityValue);
    }
}

