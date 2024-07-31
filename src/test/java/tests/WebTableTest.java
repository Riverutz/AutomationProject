package tests;

import objectData.WebTableObject;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest() {

        WebTableObject testData = new WebTableObject("src/test/resources/testData/WebTableData.json");

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToElementsMenu();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.navigateToWebTablesSubMenu();

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.addEntry(testData);
        webTablePage.editEntry(testData);
    }
}
