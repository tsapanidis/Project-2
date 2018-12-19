package com.jp2.controller.rest;

import com.jp2.model.OwnerModel;
import com.jp2.mappers.OwnerServiceToModel;
import com.jp2.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OwnerRESTController {

    @Autowired
    private OwnerService service;

    @Autowired
    private OwnerServiceToModel mapper;

    @GetMapping("/Owners/Data")
    public ResponseEntity<List<OwnerModel>> fetchRepairs(HttpSession session) {
        return ResponseEntity.ok(mapper.mapToOwnerModels(service.findAll()));
    }
}
