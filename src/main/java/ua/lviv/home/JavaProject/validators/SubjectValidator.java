package ua.lviv.home.JavaProject.validators;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.lviv.home.JavaProject.domain.Subject;

@Component
public class SubjectValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Subject.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Subject subjectToValidate = (Subject) target;
        if(StringUtils.isEmpty(subjectToValidate.getName())){
            errors.rejectValue("name","empty");
        }
        if(subjectToValidate.getMaxGrade()==0|| subjectToValidate.getMaxGrade()<0){
            errors.rejectValue("maxGrade","null");
        }
        if(subjectToValidate.getMaxGrade()>20){
            errors.rejectValue("maxGrade","moreThan");
        }
    }
}
