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
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {
    public WebDriver driver;


    @Test
    public void metodaTest() {


        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.navigateToFormsMenu();

        FormsPage formsPage = new FormsPage(driver);
        formsPage.navigateToPracticeForm();

        String firstNameValue = "Daniel Alexandru";
        String lastNameValue = "Vlasceanu";
        String userEmailValue = "ps5@yahoo.ro";
        String genderValue = "Male";
        String userNumberValue = "0741223451";
        String dateOfBirthDaysValue = "23";
        String subjectsInputValue = "Arts";
        List<String> hobbiesValue = Arrays.asList("Sports", "Music");
        String picturePathValue = "sample.txt";
        String currentAddressValue = "Str. Hohoho";
        String stateElementValue = "Uttar Pradesh";
        String cityValue = "Agra";

        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.fillEntireForm(firstNameValue, lastNameValue, userEmailValue,
                genderValue, userNumberValue, dateOfBirthDaysValue, subjectsInputValue, hobbiesValue,
                picturePathValue, currentAddressValue, stateElementValue, cityValue);

        practiceFormPage.validateEntireForm(firstNameValue,
                lastNameValue, userEmailValue, genderValue,
                userNumberValue, subjectsInputValue, hobbiesValue,
                picturePathValue, currentAddressValue,
                stateElementValue, cityValue);
    }
}

