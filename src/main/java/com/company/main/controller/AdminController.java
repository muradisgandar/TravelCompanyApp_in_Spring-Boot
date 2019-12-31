/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.controller;

import com.company.main.entities.Travelpackages;
import com.company.main.entities.Users;
import com.company.main.services.TravelPackagesServiceInter;
import com.company.main.services.UsersServiceInter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author murad_isgandar
 */
@Controller
@RequestMapping("/adminpage")
public class AdminController {

    @Autowired
    TravelPackagesServiceInter service;

    @Autowired
    UsersServiceInter userservice;

    @GetMapping
    public ModelAndView getAll(ModelAndView modelAndView) {
        List<Travelpackages> list = service.getAll();
        modelAndView.addObject("travelList", list);

        modelAndView.setViewName("admin/adminpage");

        return modelAndView;
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(value = "countryname") String countryname,
            @RequestParam(value = "date") String date,
            ModelAndView modelAndView) {

        if ((countryname != null && !countryname.isEmpty()) || (date != null && !date.isEmpty())) {
            List<Travelpackages> list = service.getAllByParameters(countryname, date);
            modelAndView.addObject("travelList", list);
            modelAndView.setViewName("admin/adminpage");
        } else {
            return new ModelAndView("redirect:/adminpage");
        }


        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("addPackage") Travelpackages t) {
        service.add(t);
        return new ModelAndView("redirect:/adminpage");
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("updatePackage") Travelpackages t) {
        service.update(t);
        return new ModelAndView("redirect:/adminpage");
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("deletePackage") Travelpackages t) {
        service.delete(t.getId());
        return new ModelAndView("redirect:/adminpage");
    }

    @GetMapping("/users")
    public ModelAndView permit(ModelAndView modelAndView) {
        List<Users> falseEnabled = new ArrayList<>();
        List<Users> trueEnabled = new ArrayList<>();

        List<Users> allUsers = userservice.getAllUsers();

        for (Users u : allUsers) {
            if (u.isEnabled()) {
                trueEnabled.add(u);
            } else {
                falseEnabled.add(u);
            }
        }

        modelAndView.addObject("falseEnabled", falseEnabled);//for inactive users
        modelAndView.addObject("trueEnabled", trueEnabled);//for active users
        modelAndView.setViewName("admin/usermanagement");
        
        return modelAndView;
    }

    @PostMapping("/users/access")
    public ModelAndView access(@RequestParam("id") Integer id) {
        userservice.setEnable(id);
        return new ModelAndView("redirect:/adminpage/users");
    }

}
