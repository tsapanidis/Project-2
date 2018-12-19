package com.jp2.controller.rest;

import com.jp2.model.RepairModel;
import com.jp2.domain.enumerations.UserType;
import com.jp2.mappers.RepairServiceToModel;
import com.jp2.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class RepairRESTController {

    @Autowired
    private RepairService service;

    @Autowired
    private RepairServiceToModel mapper;

    @GetMapping("/Repairs/Data")
    public ResponseEntity<List<RepairModel>> fetchRepairs(Model model,HttpSession session) {
        List<RepairModel> repairs;
        if (session.getAttribute("UserType") == UserType.USER) {
            repairs = mapper.mapToRepairModels(service.findByVAT((int) session.getAttribute("UserVAT")));
        } else {
            repairs = mapper.mapToRepairModels(service.getfirst10Repairs());
        }
        return ResponseEntity.ok(repairs);
    }
}
