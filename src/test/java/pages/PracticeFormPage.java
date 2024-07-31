package pages;

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
        elementMethods.fillElement(firstName, testData.getFirstName());
        elementMethods.fillElement(lastName, testData.getLastName());
        elementMethods.fillElement(userEmail, testData.getUserEmail());
        pageMethods.scrollPage(0, 350);

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

        elementMethods.fillElement(userNumber, testData.getUserNumber());
        elementMethods.clickElement(dateOfBirth);
        elementMethods.selectByTextElement(dateOfBirthMonth, "September");
        elementMethods.selectByValue(year, "1990");

        for (Integer index = 0; index < dateOfBirthDays.size(); index++) {
            if (dateOfBirthDays.get(index).getText().equals(testData.getDateOfBirthDays())) {
                elementMethods.clickElement(dateOfBirthDays.get(index));
                break;
            }
        }

        elementMethods.fillElement(subjectsInput, testData.getSubjectsInput());
        elementMethods.pressElement(subjectsInput, Keys.ENTER);

        for (Integer index = 0; index < hobbiesElements.size(); index++) {
            String hobbyText = hobbiesElements.get(index).getText();
            if (testData.getHobbies().contains(hobbyText)) {
                elementMethods.clickJSElement(hobbiesElements.get(index));
            }
        }

        File file = new File("src/test/resources/" + testData.getPicturePath());
        uploadPictureElement.sendKeys(file.getAbsolutePath());

        elementMethods.fillElement(currentAddress, testData.getCurrentAddress());
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(state);

        elementMethods.fillElement(stateElement, testData.getStateElement());
        elementMethods.pressElement(stateElement, Keys.ENTER);

        elementMethods.fillElement(city, testData.getCity());
        elementMethods.pressElement(city, Keys.ENTER);
        pageMethods.scrollPage(0, 350);
        elementMethods.clickJSElement(submit);
    }

    public void validateEntireForm(PracticeFormObject testData) {
        Assert.assertEquals(thankYouMessage.getText(),"Thanks for submitting the form");
        Assert.assertEquals(tableValues.get(0).getText(),"Student Name " + testData.getFirstName() + " " + testData.getLastName());
        Assert.assertEquals(tableValues.get(1).getText(),"Student Email " + testData.getUserEmail());
        Assert.assertEquals(tableValues.get(2).getText(),"Gender " + testData.getGender());
        Assert.assertEquals(tableValues.get(3).getText(),"Mobile " + testData.getUserNumber());
        Assert.assertEquals(tableValues.get(5).getText(),"Subjects " + testData.getSubjectsInput());
        String expectedHobbiesText = "Hobbies " + String.join(", ", testData.getHobbies());
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);
        Assert.assertEquals(tableValues.get(7).getText(),"Picture " + testData.getPicturePath());
        Assert.assertEquals(tableValues.get(8).getText(),"Address " + testData.getCurrentAddress());
        Assert.assertEquals(tableValues.get(9).getText(),"State and City " + testData.getStateElement() + " " + testData.getCity());
    }
}
