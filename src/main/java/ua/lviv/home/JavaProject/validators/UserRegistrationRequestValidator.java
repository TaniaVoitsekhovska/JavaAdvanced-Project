package ua.lviv.home.JavaProject.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.lviv.home.JavaProject.dtos.UserRegisterRequest;

@Component
public class UserRegistrationRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserRegisterRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRegisterRequest request = (UserRegisterRequest) target;
        if(request.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", "empty");
        }
    }
}