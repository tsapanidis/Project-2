package com.jp2.mappers;

import com.jp2.model.OwnerModel;
import com.jp2.domain.Owner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OwnerServiceToModel {

    public List<OwnerModel> mapToOwnerModels(List<Owner> owners) {
        List<OwnerModel> ownerModels = new ArrayList<>();
        owners.stream().forEach(o->ownerModels.add(mapToOwnerModel(o)));
        return ownerModels;
    }

    public OwnerModel mapToOwnerModel(Owner owner) {
        OwnerModel ownerModel = new OwnerModel();
        ownerModel.setID(owner.getOwnerID());
        ownerModel.setFirstName(owner.getFirstName());
        ownerModel.setLastName(owner.getLastName());
        ownerModel.setAddress(owner.getAddress());
        ownerModel.setEmail(owner.getEmail());
        ownerModel.setUsertype(owner.getUsertype());
        ownerModel.setVAT(owner.getVAT());
        ownerModel.setPassword(owner.getPassword());
        ownerModel.setBrand(owner.getBrand());
        ownerModel.setPlate(owner.getPlate());
        return ownerModel;
    }
}
