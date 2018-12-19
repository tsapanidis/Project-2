package com.jp2.mappers;

import com.jp2.forms.RegisterForm;
import com.jp2.model.OwnerModel;
import org.springframework.stereotype.Component;

@Component
public class FormToOwnerMapper {

    public OwnerModel mapToOwnerModel(RegisterForm registerForm) {
        OwnerModel ownerModel = new OwnerModel();
        ownerModel.setID(registerForm.getId());
        ownerModel.setEmail(registerForm.getEmail());
        ownerModel.setPassword(registerForm.getPassword());
        ownerModel.setFirstName(registerForm.getFirstName());
        ownerModel.setLastName(registerForm.getLastName());
        ownerModel.setVAT(Integer.parseInt(registerForm.getVat()));
        ownerModel.setAddress(registerForm.getAddress());
        ownerModel.setBrand(registerForm.getBrand());
        ownerModel.setPlate(registerForm.getPlate());
        ownerModel.setUsertype(registerForm.getUsertype());
        return ownerModel;
    }
}
