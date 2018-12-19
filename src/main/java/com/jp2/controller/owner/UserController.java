package com.jp2.controller.owner;

import com.jp2.forms.LoginForm;
import com.jp2.domain.Owner;
import com.jp2.exceptions.OwnerNotFoundException;
import com.jp2.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.jp2.utils.GlobalAttributes.PAGE_MODE;

@Controller
public class UserController {

    @Autowired
    private OwnerService service;

    @GetMapping("/")
    public String Boot(){ return "redirect:/login";}

    @GetMapping("/login")
    public String getLogin(Model model,HttpSession session){
        if(session.getAttribute("UserType") != null){
            return "redirect:/"+session.getAttribute(PAGE_MODE);
        }
        model.addAttribute("LoginForm",new LoginForm());
        return "HomePages/login";}

    @PostMapping("/login")
    public String doLogin(Model model, HttpSession session, @Valid @ModelAttribute("LoginForm") LoginForm loginForm, BindingResult result){
       if (result.hasErrors()){
           model.addAttribute("message","Please give a valid Email");
           return "HomePages/login";
       }
            Owner owner = service.findByMail(loginForm.getEmail()).orElseThrow(OwnerNotFoundException::new);
            if (owner.getPassword().equals(loginForm.getPass())){
                session.setAttribute("UserName", owner.getFirstName());
                session.setAttribute("UserType",owner.getUsertype());
                session.setAttribute("UserVAT",owner.getVAT());
                return "redirect:/Repairs";
            }
        model.addAttribute("message","Wrong Email/Password");
        return "HomePages/login";
    }

    @GetMapping("/errorcred")
    public String HandleError(Model model){
        model.addAttribute("message","Wrong Email/Password");
        return "HomePages/login";
    }

    @ExceptionHandler(OwnerNotFoundException.class)
    public String handleMissingOwner(HttpServletRequest request, RedirectAttributes reAttr,RuntimeException e){
        reAttr.addFlashAttribute("message","This Email doesn't exist");
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String doLogout(HttpServletRequest request){
        //String[] names = {"UserName", "UserType", "UserVAT","SPRING_SECURITY_CONTEXT"};
       // for (String name:names) {
       //     session.removeAttribute(name);
       // }
        try {
            request.logout();
            HttpSession session = request.getSession();
            session.invalidate();
        }catch (ServletException e) {
            System.err.println(e.getMessage());
        }
        return "redirect:/";
    }

}
