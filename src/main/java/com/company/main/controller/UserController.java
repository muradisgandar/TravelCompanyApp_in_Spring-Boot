/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.controller;

import com.company.main.dto.UserDTO;
import com.company.main.entities.Travelpackages;
import com.company.main.entities.Users;
import com.company.main.services.TravelPackagesServiceInter;
import com.company.main.services.UsersServiceInter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author murad_isgandar
 */
@Controller
public class UserController {

    @Autowired
    UsersServiceInter userservice;

    @Autowired
    TravelPackagesServiceInter travelservice;

    @GetMapping("/userpage")
    public String userGet(Model model) {
        List<Travelpackages> list = travelservice.getAll();
        model.addAttribute("travelList", list);

        Users u = new Users();
        model.addAttribute("user", u);
        return "/userpage";
    }

    @PostMapping("/userpage/add")
    public String userAdd(@ModelAttribute("user") UserDTO userdto,
            @RequestParam(value = "tour_id") Travelpackages tour_id) {
        userdto.setTourId(tour_id);
        userservice.addUserOtherDetails(new Users(null, userdto.getName(), userdto.getSurname(), userdto.getAge(), userdto.getGender(), userdto.getPhoneNumber(), userdto.getMail(), userdto.getUsername(), userdto.getPassword(), true, userdto.getTourId()));
        return "redirect:/userpage";
    }

}
