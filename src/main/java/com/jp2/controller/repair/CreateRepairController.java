package com.jp2.controller.repair;

import com.jp2.forms.RepairForm;
import com.jp2.model.RepairModel;
import com.jp2.domain.enumerations.UserType;
import com.jp2.mappers.FormToRepairMapper;
import com.jp2.service.OwnerService;
import com.jp2.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.text.ParseException;

import static com.jp2.utils.GlobalAttributes.CREATE_FORM;
import static com.jp2.utils.GlobalAttributes.ERROR_MESSAGE;

@Controller
public class CreateRepairController {


    @Autowired
    private OwnerService serviceOwner;

    @Autowired
    private RepairService serviceRepair;

    @Autowired
    private FormToRepairMapper mapper;

    @GetMapping(value = "/Repairs/Create")
    public String createRepair (Model model, HttpSession session){
        if (session.getAttribute("UserType") == UserType.ADMIN) {
            model.addAttribute(CREATE_FORM, new RepairForm());
            model.addAttribute("action","/Repairs/Create");
            model.addAttribute("button","Create");
            if (session.getAttribute(ERROR_MESSAGE) != null){
                model.addAttribute(ERROR_MESSAGE,session.getAttribute(ERROR_MESSAGE));
            }
            return "HomePages/CreateRepair";
       }
        return  "redirect:/Repairs";
    }

    @PostMapping(value = "/Repairs/Create")
    public String create (Model model,
                          @Valid @ModelAttribute(CREATE_FORM)
                                  RepairForm createForm,
                          BindingResult bindingResult,
                          HttpSession session) {

        if (bindingResult.hasErrors()) {
            session.setAttribute(ERROR_MESSAGE, bindingResult.getAllErrors().get(0).getDefaultMessage());
            return "redirect:/Repairs/Create";
        }

        if(serviceOwner.findByVat(Integer.parseInt(createForm.getVat())).isEmpty()){
            session.setAttribute(ERROR_MESSAGE, "Owner doesn't exist!");
            return "redirect:/Repairs/Create";
        }

        RepairModel repairModel = mapper.mapToRepairModel(createForm);
        try {
            serviceRepair.Create(repairModel);
        }catch(ParseException e){
            System.err.println(e.getMessage());
        }
        return "redirect:/Repairs";

    }

}
