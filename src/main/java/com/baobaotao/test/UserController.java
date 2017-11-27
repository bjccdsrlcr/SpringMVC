package com.baobaotao.test;

/**
 * Author: bjccdsrlcr
 * Date: 2017/11/27 0027
 * Time: 16:14
 */

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController extends MultiActionController{

   public ModelAndView home(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
      ModelAndView model = new ModelAndView("loser");
      model.addObject("message", "主页面(Home方法)");
      return model;
   }

   public ModelAndView add(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
      ModelAndView model = new ModelAndView("loser");
      model.addObject("message", "添加(Add方法)");
      return model;
   }

   public ModelAndView remove(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
      ModelAndView model = new ModelAndView("loser");
      model.addObject("message", "删除(Remove方法)");
      return model;
   }
}