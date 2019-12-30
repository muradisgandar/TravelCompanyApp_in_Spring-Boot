/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.controller;

import com.company.main.entities.Users;
import com.company.main.services.AuthoritiesServiceInter;
import com.company.main.services.UsersServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author murad_isgandar
 */
@Controller
public class LoginAndRegistration {
    
    @Autowired
    UsersServiceInter service;
    
    @Autowired
    AuthoritiesServiceInter authoritiesService;
    
    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }
    
    @RequestMapping("/registration")
    public ModelAndView registerPage(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    
    @RequestMapping(value = "/registration/register", method = RequestMethod.POST)
    public ModelAndView userRegister(@ModelAttribute("register") Users u) {
        u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));//for encoding user password then addUserOtherDetails db
        service.addUsernameAndPassword(u);
        
        authoritiesService.addAuthority(u);
        return new ModelAndView("redirect:/login");
    }
    
    
    
}
