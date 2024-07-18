package tests;

import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.SharedData;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {
        prepareEnvironment();

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
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

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
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

