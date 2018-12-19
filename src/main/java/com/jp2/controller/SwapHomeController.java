package com.jp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

import static com.jp2.utils.GlobalAttributes.PAGE_MODE;

@Controller
public class SwapHomeController {

    @GetMapping(value = "/Swap")
    public String create_stub(HttpSession session){
        if (session.getAttribute(PAGE_MODE) == "Owners"){
            return "redirect:/Repairs";
        }else{
            return "redirect:/Owners";
        }
    }
}
