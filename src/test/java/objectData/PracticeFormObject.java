package objectData;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PracticeFormObject extends GeneralObject {
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
}
