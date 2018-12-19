package com.jp2.controller.owner;

import com.jp2.forms.SearchForm;
import com.jp2.model.OwnerModel;
import com.jp2.model.OwnerNames;
import com.jp2.model.OwnerSearchNames;
import com.jp2.domain.enumerations.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.jp2.utils.GlobalAttributes.ERROR_MESSAGE;
import static com.jp2.utils.GlobalAttributes.PAGE_MODE;

@Controller
public class OwnerController {

    @Autowired
    private OwnerNames names;

    @Autowired
    private OwnerSearchNames searchNames;

    @GetMapping("/Owners")
    public String getRepairs(Model model, HttpSession session){
        UserType type ;
        List<OwnerModel> repairs;
        session.setAttribute(PAGE_MODE,"Owners");
        session.removeAttribute(ERROR_MESSAGE);
        if (session.getAttribute("UserType") != null){
            type = (UserType)session.getAttribute("UserType");
            model.addAttribute("HEAD",names.GetOwnerNames());
            model.addAttribute("NMODE","Repairs");
            if (type == UserType.ADMIN) {
                model.addAttribute("Secret", "yes");
            }
            model.addAttribute("SEARCH",searchNames.GetOwnerNames());
            model.addAttribute("UserName",session.getAttribute("UserName"));
            model.addAttribute("UserType",session.getAttribute("UserType"));
            model.addAttribute("SearchForm", new SearchForm());
            return "HomePages/HomePage";
        }else{
            return "redirect:/";
        }
    }
}
