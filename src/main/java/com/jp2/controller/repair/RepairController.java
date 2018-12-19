package com.jp2.controller.repair;

import com.jp2.domain.Owner;
import com.jp2.exceptions.OwnerNotFoundException;
import com.jp2.forms.SearchForm;
import com.jp2.model.RepairModel;
import com.jp2.model.RepairNames;
import com.jp2.model.RepairSearchNames;
import com.jp2.domain.enumerations.UserType;
import com.jp2.mappers.RepairServiceToModel;
import com.jp2.service.OwnerService;
import com.jp2.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.jp2.utils.GlobalAttributes.ERROR_MESSAGE;

@Controller
public class RepairController {
    @Autowired
    private OwnerService service;

    @Autowired
    private RepairServiceToModel mapper;

    @Autowired
    private RepairSearchNames searchNames;

    @Autowired
    private RepairNames names;

    @GetMapping("/Repairs")
    public String getRepairs(Model model, HttpSession session){
        UserType type ;
        List<RepairModel> repairs;
        session.setAttribute("Mode","Repairs");
        session.removeAttribute(ERROR_MESSAGE);
        Owner owner = service.findByMail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(OwnerNotFoundException::new);
        session.setAttribute("UserName", owner.getFirstName());
        session.setAttribute("UserType",owner.getUsertype());
        session.setAttribute("UserVAT",owner.getVAT());
        if (session.getAttribute("UserType") != null){
            type = (UserType)session.getAttribute("UserType");
            model.addAttribute("HEAD",names.GetRepairNames());
            model.addAttribute("NMODE","Owners");
            //model.addAttribute("Data",repairs);
            if (type == UserType.ADMIN) {
                model.addAttribute("Secret", "yes");
            }
            model.addAttribute("SEARCH",searchNames.GetRepairNames());
            model.addAttribute("UserName",session.getAttribute("UserName"));
            model.addAttribute("UserType",session.getAttribute("UserType"));
            model.addAttribute("SearchForm", new SearchForm());
            return "HomePages/HomePage";
        }else{
            return "redirect:/";
        }
    }
}
