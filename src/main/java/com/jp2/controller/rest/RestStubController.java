package com.jp2.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

import static com.jp2.utils.GlobalAttributes.PAGE_MODE;

@Controller
public class RestStubController {

    @GetMapping("/Data")
    public String create_stub(HttpSession session){
        return "redirect:/"+session.getAttribute(PAGE_MODE)+"/Data";
    }
}
