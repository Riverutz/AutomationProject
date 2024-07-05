package pages;

import methods.ElementMethods;
import methods.PageMethods;
import methods.WindowMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public WindowMethods windowMethods;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        windowMethods = new WindowMethods(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addRecordButton;
    @FindBy(id = "firstName")
    public WebElement firstName;
    @FindBy(id = "lastName")
    public WebElement lastName;
    @FindBy(id = "userEmail")
    public WebElement userEmail;
    @FindBy(id = "age")
    public WebElement age;
    @FindBy(id = "salary")
    public WebElement salary;
    @FindBy(id = "department")
    public WebElement department;
    @FindBy(id = "submit")
    public WebElement submit;

    @FindBy(id = "edit-record-4")
    public WebElement editRecord4;
    @FindBy(id = "salary")
    public WebElement salaryEdit;
    @FindBy(id = "department")
    public WebElement editDepartment;

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
