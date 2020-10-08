package com.atguigu.atcrowdfunding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 用户首页
     */
    @RequestMapping("/index")
    public String index(){
        return "user/index";
    }
}
