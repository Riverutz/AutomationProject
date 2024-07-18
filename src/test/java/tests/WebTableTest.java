package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToElementsMenu();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.navigateToWebTablesSubMenu();

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.addEntry("Daniel", "Vlasceanu",
                "ps5@yahoo.ro", "33" ,
                "1500", "Testing"
                );
        webTablePage.editEntry("2500", "Programming");

    }
}
