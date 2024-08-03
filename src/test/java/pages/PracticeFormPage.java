package pages;

import loggerUtility.LogUtil;
import objectData.PracticeFormObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage{
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(xpath = "//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']")
    private List<WebElement> genderElements;

    @FindBy(id = "userNumber")
    private WebElement userNumber;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirth;

    @FindBy(className = "react-datepicker__month-select")
    private WebElement dateOfBirthMonth;

    @FindBy(className = "react-datepicker__year-select")
    private WebElement year;

    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']")
    private List<WebElement> dateOfBirthDays;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    @FindBy(xpath = "//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']")
    private List<WebElement> hobbiesElements;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPictureElement;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "react-select-3-input")
    private WebElement stateElement;

    @FindBy(id = "react-select-4-input")
    private WebElement city;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submit;

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement thankYouMessage;

    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr")
    private List<WebElement> tableValues;

    public void fillEntireForm(PracticeFormObject testData)
    {
        pageMethods.scrollPage(0,350);
        LogUtil.info("The user scrolled down the page!");
        elementMethods.fillElement(firstName, testData.getFirstName());
        LogUtil.info("The user filled the First Name field with the value: " + testData.getFirstName());
        elementMethods.fillElement(lastName, testData.getLastName());
        LogUtil.info("The user filled the Last Name field with the value: " + testData.getLastName());
        elementMethods.fillElement(userEmail, testData.getUserEmail());
        LogUtil.info("The user filled the Email field with the value: " + testData.getUserEmail());
        pageMethods.scrollPage(0, 350);
        LogUtil.info("The user scrolled down the page!");

        switch (testData.getGender()) {
            case "Male":
                elementMethods.clickElement(genderElements.get(0));
                break;
            case "Female":
                elementMethods.clickElement(genderElements.get(1));
                break;
            case "Other":
                elementMethods.clickElement(genderElements.get(2));
                break;
        }
        LogUtil.info("The user selects the gender: " + testData.getGender());

        elementMethods.fillElement(userNumber, testData.getUserNumber());
        LogUtil.info("The user filled the Mobile field with the value: " + testData.getUserNumber());
        elementMethods.clickElement(dateOfBirth);
        LogUtil.info("The user clicked to select the Date of Birth");
        elementMethods.selectByTextElement(dateOfBirthMonth, "September");
        LogUtil.info("The user has selected the Birthday Month as September");
        elementMethods.selectByValue(year, "1990");
        LogUtil.info("The user has selected the Birthday Year as 1990");

        for (Integer index = 0; index < dateOfBirthDays.size(); index++) {
            if (dateOfBirthDays.get(index).getText().equals(testData.getDateOfBirthDays())) {
                elementMethods.clickElement(dateOfBirthDays.get(index));
                break;
            }
        }
        LogUtil.info("The user submitted the Date of Birth: " + testData.getDateOfBirthDays());

        elementMethods.fillElement(subjectsInput, testData.getSubjectsInput());
        LogUtil.info("The user selected the following Subjects: " + testData.getSubjectsInput());
        elementMethods.pressElement(subjectsInput, Keys.ENTER);
        LogUtil.info("The user submitted their chosen subjects.");

        for (Integer index = 0; index < hobbiesElements.size(); index++) {
            String hobbyText = hobbiesElements.get(index).getText();
            if (testData.getHobbies().contains(hobbyText)) {
                elementMethods.clickJSElement(hobbiesElements.get(index));
            }
        }
        LogUtil.info("The user has selected the following Hobbies: " + testData.getHobbies());

        File file = new File("src/test/resources/" + testData.getPicturePath());
        uploadPictureElement.sendKeys(file.getAbsolutePath());
        LogUtil.info("The user uploaded a file. ");

        elementMethods.fillElement(currentAddress, testData.getCurrentAddress());
        LogUtil.info("The user filled the Current Address field with the value: " + testData.getCurrentAddress());
        pageMethods.scrollPage(0, 350);
        LogUtil.info("The user scrolled down the page! ");
        elementMethods.clickElement(state);
        LogUtil.info("The user clicked on State element. ");

        elementMethods.fillElement(stateElement, testData.getStateElement());
        LogUtil.info("The user has chosen the following State: " + testData.getStateElement());
        elementMethods.pressElement(stateElement, Keys.ENTER);
        LogUtil.info("The user submitted their chosen State.");

        elementMethods.fillElement(city, testData.getCity());
        LogUtil.info("The user has chosen the following City: " + testData.getCity());
        elementMethods.pressElement(city, Keys.ENTER);
        LogUtil.info("The user submitted their chosen City.");
        pageMethods.scrollPage(0, 350);
        elementMethods.clickJSElement(submit);
        LogUtil.info("The user submitted the form. ");
    }

    public void validateEntireForm(PracticeFormObject testData) {
        System.out.println(" ");
        System.out.println("VALIDATIONS");
        System.out.println(" ");
        Assert.assertEquals(thankYouMessage.getText(),"Thanks for submitting the form");
        LogUtil.info("The user validates the presence of " + thankYouMessage.getText());
        Assert.assertEquals(tableValues.get(0).getText(),"Student Name " + testData.getFirstName() + " " + testData.getLastName());
        LogUtil.info("The user validates the presence of " + testData.getFirstName() + " " + testData.getLastName());
        Assert.assertEquals(tableValues.get(1).getText(),"Student Email " + testData.getUserEmail());
        LogUtil.info("The user validates the presence of " + testData.getUserEmail());
        Assert.assertEquals(tableValues.get(2).getText(),"Gender " + testData.getGender());
        LogUtil.info("The user validates the presence of " + testData.getGender());
        Assert.assertEquals(tableValues.get(3).getText(),"Mobile " + testData.getUserNumber());
        LogUtil.info("The user validates the presence of " + testData.getUserNumber());
        Assert.assertEquals(tableValues.get(5).getText(),"Subjects " + testData.getSubjectsInput());
        LogUtil.info("The user validates the presence of " + testData.getSubjectsInput());
        String expectedHobbiesText = "Hobbies " + String.join(", ", testData.getHobbies());
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);
        LogUtil.info("The user validates the presence of " + expectedHobbiesText);
        Assert.assertEquals(tableValues.get(7).getText(),"Picture " + testData.getPicturePath());
        LogUtil.info("The user validates the presence of " + testData.getPicturePath());
        Assert.assertEquals(tableValues.get(8).getText(),"Address " + testData.getCurrentAddress());
        LogUtil.info("The user validates the presence of " + testData.getCurrentAddress());
        Assert.assertEquals(tableValues.get(9).getText(),"State and City " + testData.getStateElement() + " " + testData.getCity());
        LogUtil.info("The user validates the presence of " + testData.getStateElement() + " " + testData.getCity());
    }
}
