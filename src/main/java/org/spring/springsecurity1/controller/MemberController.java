package org.spring.springsecurity1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping({"","/index"})
    public @ResponseBody String index(){
        return "member/index";
    }


    @GetMapping("/join")
    public @ResponseBody String join(){
        return "member/join";
    }


    @GetMapping("/memberShip")
    public @ResponseBody String memberShip(){

        return "memberShip";
    }


    @GetMapping("/loginOk")
    public String loginOk(){
        return "member/loginOk";
    }
    @GetMapping("/loginFail")
    public String loginFail(){
        return "member/loginFail";
    }

    @GetMapping("/logOutOk")
    public String logoutOk(){
        return "member/logOutOk";
    }
    @GetMapping("/login")
    public String login(){
        return "member/login";
    }


}