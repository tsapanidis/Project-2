package com.jp2.controller.owner;

import com.jp2.forms.RegisterForm;
import com.jp2.model.OwnerModel;
import com.jp2.domain.enumerations.UserType;
import com.jp2.domain.Owner;

import com.jp2.mappers.FormToOwnerMapper;

import com.jp2.mappers.OwnerToFormMapper;
import com.jp2.service.OwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.jp2.utils.GlobalAttributes.*;

@Controller
public class UpdateUserController {

    @Autowired
    private OwnerService service;

    @Autowired
    private OwnerToFormMapper ownerToFormMapper;


    @Autowired
    private FormToOwnerMapper formToOwnerMapper;

    @GetMapping(value = "/Owners/Update/{id}")
    public String updateRepair(@PathVariable Long id,
                               Model model,
                               HttpSession session) {
        if (session.getAttribute("UserType") == UserType.ADMIN) {
            Owner owner = service.findById(id).get();
            RegisterForm registerForm = ownerToFormMapper.mapToOwnerForm(owner);
            model.addAttribute(REGISTER_FORM, registerForm);
            model.addAttribute("action","/Owners/Update/");
            model.addAttribute("button","Update");
            if (session.getAttribute(ERROR_MESSAGE) != null){
                model.addAttribute(ERROR_MESSAGE,session.getAttribute(ERROR_MESSAGE));
            }
            return "HomePages/CreateUser";
        }
        return  "redirect:/Owners";
    }

    @PostMapping(value = "/Owners/Update/")
    public String update(Model model,
                         @Valid @ModelAttribute(REGISTER_FORM)
                                 RegisterForm registerForm,
                         BindingResult bindingResult,
                         HttpSession session){
        if (bindingResult.hasErrors()) {
            session.setAttribute(ERROR_MESSAGE, bindingResult.getAllErrors().get(0).getDefaultMessage());
            return "redirect:/Owners/Update";
        }
        if(!service.findByVat(Integer.parseInt(registerForm.getVat())).isEmpty()){
            if(service.findByVat(Integer.parseInt(registerForm.getVat())).get().getOwnerID() != registerForm.getId()){
                session.setAttribute(ERROR_MESSAGE,"Owner already exists!");
                return "redirect:/Owners/Update";
            }
        }

        OwnerModel ownerModel = formToOwnerMapper.mapToOwnerModel(registerForm);
        service.Update(ownerModel);
        return "redirect:/Owners";
    }

    @GetMapping("/Owners/Delete/{id}")
    public String deleteRepair(@PathVariable long id){
        service.Delete(id);
        return "redirect:/Owners";
    }
}

