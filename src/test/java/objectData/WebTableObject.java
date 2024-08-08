package objectData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebTableObject extends GeneralObject {
    private String firstNameValue;
    private String lastNameValue;
    private String userEmailValue;
    private String ageValue;
    private String salaryValue;
    private String departmentValue;
    private String editSalaryValue;
    private String editDepartmentValue;

    public WebTableObject(String filePath) {
        fromJsonToObject(filePath);
    }
}

