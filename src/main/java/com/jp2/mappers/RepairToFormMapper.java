package com.jp2.mappers;


import com.jp2.forms.RepairForm;
import com.jp2.domain.Repair;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Component
    public class RepairToFormMapper {

        public RepairForm mapToRepairForm(Repair repair) {
            RepairForm repairForm = new RepairForm();
            SimpleDateFormat sdfr = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            repairForm.setRepairID(repair.getRepairID());
            repairForm.setDate(sdfr.format(repair.getDate()));
            repairForm.setStatus(repair.getStatus());
            repairForm.setRepairType(repair.getRepairtype());
            repairForm.setPrice(repair.getPrice());
            repairForm.setVat(Integer.toString(repair.getOwner().getVAT()).replace(".",""));
            repairForm.setDescription(repair.getDescription());

            return repairForm;
        }
    }


