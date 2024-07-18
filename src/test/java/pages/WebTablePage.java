package pages;

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

    public void addEntry(String firstNameValue, String lastNameValue,
                         String userEmailValue, String ageValue,
                         String salaryValue, String departmentValue) {

        elementMethods.clickElement(addRecordButton);
        elementMethods.fillElement(firstName, firstNameValue);
        elementMethods.fillElement(lastName, lastNameValue);
        elementMethods.fillElement(userEmail, userEmailValue);
        elementMethods.fillElement(age, ageValue);
        elementMethods.fillElement(salary, salaryValue);
        elementMethods.fillElement(department, departmentValue);
        elementMethods.clickElement(submit);
    }

    public void editEntry(String editSalaryValue, String editDepartmentValue) {

        elementMethods.clickElement(editRecord4);
        elementMethods.clearFillElement(salaryEdit, editSalaryValue);
        elementMethods.clearFillElement(editDepartment, editDepartmentValue);
    }
}
