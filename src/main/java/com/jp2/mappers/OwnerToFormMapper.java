package com.jp2.mappers;

import com.jp2.forms.RegisterForm;
import com.jp2.domain.Owner;
import org.springframework.stereotype.Component;


@Component
public class OwnerToFormMapper {

            public RegisterForm mapToOwnerForm(Owner owner) {
            RegisterForm registerForm = new RegisterForm();
            registerForm.setId(owner.getOwnerID());
            registerForm.setVat(Integer.toString(owner.getVAT()).replace(".",""));
            registerForm.setFirstName(owner.getFirstName());
            registerForm.setLastName(owner.getLastName());
            registerForm.setAddress(owner.getAddress());
            registerForm.setEmail(owner.getEmail());
            registerForm.setPassword(owner.getPassword());
            registerForm.setBrand(owner.getBrand());
            registerForm.setPlate(owner.getPlate());
            registerForm.setUsertype(owner.getUsertype());


            return registerForm;
        }
    }

