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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author murad_isgandar
 */
@Controller
public class AdminController {
    
    @Autowired
    TravelPackagesServiceInter service;
    
//    @ModelAttribute("travel")
//    Travelpackages get(){
//        return new Travelpackages();
//    }
    
    @Autowired
    UsersServiceInter userservice;
    
    @RequestMapping("/adminpage")
    public String getAll(Model model) {
        List<Travelpackages> list = service.getAll();
        model.addAttribute("travelList", list);
        
        Travelpackages t = new Travelpackages();
        model.addAttribute("travel",t);
        
        return "adminpage";
    }
    
    @RequestMapping("/index")
    public String homePage() {
        return "index";
    }
    
    @RequestMapping("/adminpage/search")
    public String search(@RequestParam(value = "countryname") String countryname,
            @RequestParam(value = "date") String date,
            Model model) {
        List<Travelpackages> list = service.getAllByParameters(countryname, date);
        model.addAttribute("travelList", list);
        
        return "/adminpage";
    }
    
    @PostMapping("/adminpage/add")
    public String add(@ModelAttribute("addPackage")Travelpackages t) {
        service.add(t);
        return "redirect:/adminpage";
    }
    
    @PostMapping("/adminpage/update")
    public String update(@ModelAttribute("updatePackage")Travelpackages t) {
        service.update(t);
        return "redirect:/adminpage";
    }
    
    @PostMapping("/adminpage/delete")
    public String delete(@ModelAttribute("deletePackage")Travelpackages t) {
        service.delete(t.getId());
        return "redirect:/adminpage";
    }
    
    @GetMapping("/users")
    public String permit(Model model) {
        List<Users> falseEnabled = new ArrayList<>();
        List<Users> trueEnabled = new ArrayList<>();
        
        List<Users> allUsers = userservice.getAllUsers();
        
        for(Users u:allUsers){
            if(u.isEnabled()){
                trueEnabled.add(u);
            }
            else
                falseEnabled.add(u);
        }
        
        model.addAttribute("falseEnabled", falseEnabled);
        model.addAttribute("trueEnabled", trueEnabled);
        
        return "usermanagement";
    }
    
    @PostMapping("/users/access")
    public String access(@RequestParam("id") Integer id) {
        userservice.setEnable(id);
        return "redirect:/users";
    }
    
}
