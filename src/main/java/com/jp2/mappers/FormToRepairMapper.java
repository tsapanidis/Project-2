package com.jp2.mappers;

import com.jp2.forms.RepairForm;
import com.jp2.model.RepairModel;

import org.springframework.stereotype.Component;

@Component
public class FormToRepairMapper {

    public RepairModel mapToRepairModel(RepairForm repairForm) {
        RepairModel repairModel = new RepairModel();
        repairModel.setID(repairForm.getRepairID());
        repairModel.setDate(repairForm.getDate());
        repairModel.setStatus(repairForm.getStatus());
        repairModel.setRepairtype(repairForm.getRepairType());
        repairModel.setPrice(repairForm.getPrice());
        repairModel.setVat(repairForm.getVat());
        repairModel.setDescription(repairForm.getDescription());

        return repairModel;
    }
}
