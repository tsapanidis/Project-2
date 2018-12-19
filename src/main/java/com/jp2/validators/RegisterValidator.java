package com.jp2.validators;

import com.jp2.forms.RegisterForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class RegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {

        return RegisterForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        RegisterForm registrationForm = (RegisterForm) target;

        //here perform your checks
        if (registrationForm.getEmail() == null) {
            // add an error for the field called ‘email’
            errors.rejectValue("email", "email is empty");
        }

        ValidationUtils.rejectIfEmpty(errors, "vat", "Invalid Plate");
    }



}
