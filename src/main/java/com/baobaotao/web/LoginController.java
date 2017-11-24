package com.baobaotao.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.portlet.ModelAndView;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Author: bjccdsrlcr
 * Date: 2017/11/17 0017
 * Time: 14:25
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.html")
    public String loginPage(@RequestHeader("Accept-Encoding") String encoding){
        System.out.println("======================");
        return "login";
    }

    @RequestMapping(value = "/redirect")
    public String page(){
        // redirect重定向，目标写路由，不是服务器上文件的路径
        return "redirect:/login.html";
    }

    @RequestMapping(value = "/user")
    public String userInfo(Model model, @RequestParam(value = "name", defaultValue = "Guest") String name){
            name = "admin";
            model.addAttribute("name", name);
            if("admin".equals(name)){
                model.addAttribute("email", "bjccdslrc@163.com");
            }else {
                model.addAttribute("email", "not set");
            }
            return "userInfo";
    }

    @RequestMapping(value = "/web/fe/{sitePrefix}/{language}/{id}/{street}")
    public String documentView(Model model,
                               @PathVariable(value = "sitePrefix") String sitePrefix,
                               @PathVariable(value = "language") String language,
                               @PathVariable(value = "id") int id,
                               @PathVariable(value = "street") String street){
        model.addAttribute("sitePrefix", sitePrefix);
        model.addAttribute("language", language);
        model.addAttribute("id", id);
        model.addAttribute("street", street);
        return "documentView";
    }

    @RequestMapping(value = "/index.html")
    public String loginCheck (HttpServletRequest request, LoginCommand loginCommand) throws Exception{
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        if(!isValidUser){
            return "login";
        }else{
            User user = userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user", user);
            return "main";
        }
    }
}
