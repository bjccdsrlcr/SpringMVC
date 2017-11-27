package com.baobaotao.second;


import com.baobaotao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: bjccdsrlcr
 * Date: 2017/11/17 0017
 * Time: 14:25
 */
@Controller
public class SecondController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/second.html")
    public String loginPage(){
        return "second";
    }

}
