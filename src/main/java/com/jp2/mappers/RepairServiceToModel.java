package com.jp2.mappers;

import com.jp2.model.RepairModel;
import com.jp2.domain.Repair;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class RepairServiceToModel {

    public List<RepairModel> mapToRepairModels(List<Repair> repairs) {
        List<RepairModel> repairModels = new ArrayList<>();
        repairs.stream().forEach(r->repairModels.add(mapToRepairModel(r)));
        return repairModels;
    }

    public RepairModel mapToRepairModel(Repair repair) {
        RepairModel repairModel = new RepairModel();
        SimpleDateFormat sdfr = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        repairModel.setDate(sdfr.format(repair.getDate()));
        repairModel.setID(repair.getRepairID());
        repairModel.setStatus(repair.getStatus());
        repairModel.setPrice(repair.getPrice());
        repairModel.setRepairtype(repair.getRepairtype());
        repairModel.setVat(Integer.toString(repair.getOwner().getVAT()));
        repairModel.setDescription(repair.getDescription());
        return repairModel;
    }
}
