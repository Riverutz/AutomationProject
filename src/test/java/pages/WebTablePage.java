package pages;

import objectData.WebTableObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablePage extends BasePage{
    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addNewRecordButton")
    private WebElement addRecordButton;
    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "userEmail")
    private WebElement userEmail;
    @FindBy(id = "age")
    private WebElement age;
    @FindBy(id = "salary")
    private WebElement salary;
    @FindBy(id = "department")
    private WebElement department;
    @FindBy(id = "submit")
    private WebElement submit;
    @FindBy(id = "edit-record-4")
    private WebElement editRecord4;
    @FindBy(id = "salary")
    private WebElement salaryEdit;
    @FindBy(id = "department")
    private WebElement editDepartment;

    public void addEntry(WebTableObject testData) {
        elementMethods.clickElement(addRecordButton);
        elementMethods.fillElement(firstName, testData.getFirstNameValue());
        elementMethods.fillElement(lastName, testData.getLastNameValue());
        elementMethods.fillElement(userEmail, testData.getUserEmailValue());
        elementMethods.fillElement(age, testData.getAgeValue());
        elementMethods.fillElement(salary, testData.getSalaryValue());
        elementMethods.fillElement(department, testData.getDepartmentValue());
        elementMethods.clickElement(submit);
    }

    public void editEntry(WebTableObject testData) {
        elementMethods.clickElement(editRecord4);
        elementMethods.clearFillElement(salaryEdit, testData.getEditSalaryValue());
        elementMethods.clearFillElement(editDepartment, testData.getEditDepartmentValue());
    }
}
