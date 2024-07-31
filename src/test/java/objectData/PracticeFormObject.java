package objectData;

import java.util.List;

public class PracticeFormObject extends GeneralObject{
    private String firstName;
    private String lastName;
    private String userEmail;
    private String gender;
    private String userNumber;
    private String dateOfBirthDays;
    private String subjectsInput;
    private List<String> hobbies;
    private String picturePath;
    private String currentAddress;
    private String stateElement;
    private String city;

    public PracticeFormObject(String filePath) {
        fromJsonToObject(filePath);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getDateOfBirthDays() {
        return dateOfBirthDays;
    }

    public void setDateOfBirthDays(String dateOfBirthDays) {
        this.dateOfBirthDays = dateOfBirthDays;
    }

    public String getSubjectsInput() {
        return subjectsInput;
    }

    public void setSubjectsInput(String subjectsInput) {
        this.subjectsInput = subjectsInput;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getStateElement() {
        return stateElement;
    }

    public void setStateElement(String stateElement) {
        this.stateElement = stateElement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
