package ua.lviv.home.JavaProject.validators;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.lviv.home.JavaProject.domain.Faculty;

@Component
public class FacultyValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Faculty.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Faculty facultyToValidate = (Faculty) target;
        if(StringUtils.isEmpty(facultyToValidate.getName())){
            errors.rejectValue("name","empty");
        }
    }
}
