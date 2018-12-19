package com.jp2.controller.owner;

import com.jp2.forms.RegisterForm;

import com.jp2.model.OwnerModel;
import com.jp2.domain.enumerations.UserType;
import com.jp2.mappers.FormToOwnerMapper;
import com.jp2.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.jp2.utils.GlobalAttributes.ERROR_MESSAGE;
import static com.jp2.utils.GlobalAttributes.REGISTER_FORM;

@Controller
public class CreateUserController {



    @Autowired
    private OwnerService service;

    @Autowired
    private FormToOwnerMapper mapper;

    @GetMapping(value = "/Owners/Create")
     public String registerUser (Model model, HttpSession session) {
            if (session.getAttribute("UserType") == UserType.ADMIN) {
                model.addAttribute(REGISTER_FORM, new RegisterForm());
                model.addAttribute("action","/Owners/Create");
                model.addAttribute("button","Create");
                if (session.getAttribute(ERROR_MESSAGE) != null){
                    model.addAttribute(ERROR_MESSAGE,session.getAttribute(ERROR_MESSAGE));
                }
                return "HomePages/CreateUser";
            }
        return "redirect:/Owners";

    }

    @PostMapping(value = "/Owners/Create")
    public String register(Model model,
                           @Valid @ModelAttribute(REGISTER_FORM)
                                   RegisterForm registerForm,
                           Errors errors,
                           HttpSession session) {

        if (errors.hasErrors()) {
            session.setAttribute(ERROR_MESSAGE, errors.getAllErrors().get(0).getDefaultMessage());
            return "redirect:/Owners/Create";
        }

        if (!service.findByVat(Integer.parseInt(registerForm.getVat())).isEmpty()) {
            session.setAttribute(ERROR_MESSAGE, "Owner already exists!");
            return "redirect:/Owners/Create";
        }

        OwnerModel ownerModel = mapper.mapToOwnerModel(registerForm);
        service.Create(ownerModel);
        return "redirect:/Owners";


    }


}
