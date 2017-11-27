package com.baobaotao.first;


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
public class FirstController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/first.html")
    public String loginPage(){
        return "first";
    }

}
