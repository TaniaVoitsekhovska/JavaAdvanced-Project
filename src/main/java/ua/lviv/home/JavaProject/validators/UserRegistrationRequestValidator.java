package ua.lviv.home.JavaProject.validators;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
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
        if (StringUtils.isEmpty(request.getFirstName())) {
            errors.rejectValue("firstName", "empty");
        }
        if (StringUtils.isEmpty(request.getLastName())) {
            errors.rejectValue("lastName", "empty");
        }
        if (request.getEmail().isEmpty()) {
            errors.rejectValue("email", "empty");
        }
        if (StringUtils.isEmpty(request.getDateOfBirth())) {
            errors.rejectValue("dateOfBirth", "empty");
        }
        if (StringUtils.isEmpty(request.getGender())) {
            errors.rejectValue("gender", "empty");
        }
        if (StringUtils.isEmpty(request.getAddress())) {
            errors.rejectValue("address", "empty");
        }
        if (request.getPhoneNumber()<=0) {
            errors.rejectValue("phoneNumber", "empty");
        } else if (request.getPhoneNumber()<999999999999L) {
            errors.rejectValue("phoneNumber", "phoneNumberLength");
        }
        if (StringUtils.isEmpty(request.getUsername())) {
            errors.rejectValue("username", "empty");
        }
        if (request.getPassword().isEmpty()) {
            errors.rejectValue("password", "empty");
        } else if (request.getPassword().length() < 8) {
            errors.rejectValue("password", "passwordLength");
        }
    }

}
