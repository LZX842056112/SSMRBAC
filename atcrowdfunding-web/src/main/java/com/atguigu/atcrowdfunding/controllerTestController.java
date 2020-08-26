package com.atguigu.atcrowdfunding;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class controllerTestController {

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }
}
