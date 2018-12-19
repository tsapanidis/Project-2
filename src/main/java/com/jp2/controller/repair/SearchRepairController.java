package com.jp2.controller.repair;

import com.jp2.forms.SearchForm;
import com.jp2.model.RepairModel;
import com.jp2.domain.enumerations.RepairSearchType;
import com.jp2.mappers.RepairServiceToModel;
import com.jp2.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Controller
public class SearchRepairController {

    @Autowired
    private RepairServiceToModel mapper;

    @Autowired
    private RepairService service;

    @GetMapping(value = "/Repairs/search")
    public ResponseEntity<List<RepairModel>> searchForRepairs(Model model, SearchForm searchForm) {
        List<RepairModel> repairs = findRepairs(searchForm);
        return ResponseEntity.ok(repairs);
    }

    private List<RepairModel> findRepairs(SearchForm searchForm) {
        SimpleDateFormat sdfr = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        RepairSearchType repairSearchType = RepairSearchType.valueOf(searchForm.getType());

        List<RepairModel> repairs = new ArrayList<>();
        switch (repairSearchType) {

            case DATE:
                try {
                    repairs = mapper.mapToRepairModels(service.findByDate(sdfr.parse(searchForm.getTerm())));
                } catch (ParseException e) {
                    System.err.println(e.getMessage());
                }
                break;


            case VAT:
                int vat = Integer.parseInt(searchForm.getTerm());
                repairs = mapper.mapToRepairModels(service.findByVAT(vat));
                break;

            case PLATE:
                repairs = mapper.mapToRepairModels(service.findByPlate(searchForm.getTerm()));
                break;
        }

        return repairs;
    }
}
