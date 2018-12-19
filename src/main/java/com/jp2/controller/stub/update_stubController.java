package com.jp2.controller.stub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

import static com.jp2.utils.GlobalAttributes.PAGE_MODE;

@Controller
public class update_stubController {

    @GetMapping(value = "/Update/{id}")
    public String create_stub(HttpSession session,@PathVariable(name="id")long id){
        return "redirect:/"+session.getAttribute(PAGE_MODE)+"/Update/"+id;
    }
}
