package org.spring.springsecurity1.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/shop")
    public @ResponseBody String shop(){
        return "shop";
    }
    @GetMapping("/manager")
    public  String manager(){
        return "member/manager";
    }
    @GetMapping("/admin")
    public  String admin(){
        return "member/admin";
    }

}