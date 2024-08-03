package pages;

import loggerUtility.LogUtil;
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
    @FindBy(id = "delete-record-4")
    private WebElement deleteEntry;

    public void addEntry(WebTableObject testData) {
        elementMethods.clickElement(addRecordButton);
        LogUtil.info("The user clicked on the Add button.");
        elementMethods.fillElement(firstName, testData.getFirstNameValue());
        LogUtil.info("The user filled the First Name field with the value " + testData.getFirstNameValue());
        elementMethods.fillElement(lastName, testData.getLastNameValue());
        LogUtil.info("The user filled the Last Name field with the value " + testData.getLastNameValue());
        elementMethods.fillElement(userEmail, testData.getUserEmailValue());
        LogUtil.info("The user filled the Email field with the value" + testData.getUserEmailValue());
        elementMethods.fillElement(age, testData.getAgeValue());
        LogUtil.info("The user filled the Age field with the value " + testData.getAgeValue());
        elementMethods.fillElement(salary, testData.getSalaryValue());
        LogUtil.info("The user filled the Salary field with the value " + testData.getSalaryValue());
        elementMethods.fillElement(department, testData.getDepartmentValue());
        LogUtil.info("The user filled the Department field with the value " + testData.getDepartmentValue());
        elementMethods.clickElement(submit);
        LogUtil.info("The user clicked on the Submit button.");
    }

    public void editEntry(WebTableObject testData) {
        elementMethods.clickElement(editRecord4);
        LogUtil.info("The user clicked on the Edit button.");
        elementMethods.clearFillElement(salaryEdit, testData.getEditSalaryValue());
        LogUtil.info("The user has edited the Salary field with a new value " + testData.getEditSalaryValue());
        elementMethods.clearFillElement(editDepartment, testData.getEditDepartmentValue());
        LogUtil.info("The user has edited the Department field with a new value " + testData.getEditDepartmentValue());
    }
    public void deleteEntry(){
        elementMethods.clickJSElement(deleteEntry);
        LogUtil.info("The user clicked on Delete button to remove the entry.");
    }
}
