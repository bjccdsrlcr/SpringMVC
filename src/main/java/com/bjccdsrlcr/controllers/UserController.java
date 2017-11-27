package com.bjccdsrlcr.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: bjccdsrlcr
 * Date: 2017/11/27 0027
 * Time: 14:46
 */
public class UserController extends MultiActionController{
     public ModelAndView home(HttpServletRequest request,
                              HttpServletResponse response) throws Exception {
      ModelAndView model = new ModelAndView("user");
      model.addObject("message", "主页面(Home方法)");
      return model;
   }

   @RequestMapping(value = "/user")
   public String index(){
         return "user";
   }
   public ModelAndView add(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
      ModelAndView model = new ModelAndView("user");
      model.addObject("message", "添加(Add方法)");
      return model;
   }

   public ModelAndView remove(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
      ModelAndView model = new ModelAndView("user");
      model.addObject("message", "删除(Remove方法)");
      return model;
   }
}
