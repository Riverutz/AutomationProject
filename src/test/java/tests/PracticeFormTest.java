package tests;

import objectData.PracticeFormObject;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.SharedData;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {

        //Pregatim datele de test specifice - path relativ "src/test/resources/testData/PracticeFormData.json"

        PracticeFormObject testData = new PracticeFormObject("src/test/resources/testData/PracticeFormData.json");

        //prepareEnvironment();

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.navigateToPracticeForm();

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(testData);
        practiceFormPage.validateEntireForm(testData);
    }
}

