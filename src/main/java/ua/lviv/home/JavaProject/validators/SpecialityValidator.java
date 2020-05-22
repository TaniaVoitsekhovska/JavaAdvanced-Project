package ua.lviv.home.JavaProject.validators;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.lviv.home.JavaProject.domain.Speciality;

@Component
public class SpecialityValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Speciality.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Speciality specialityToValidate = (Speciality) target;
        if (StringUtils.isEmpty(specialityToValidate.getTitle())) {
            errors.rejectValue("title", "empty");
        }
//        if (specialityToValidate.getTotalGrade()<0) {
//            errors.rejectValue("title", "empty");
//        }
    }
}
