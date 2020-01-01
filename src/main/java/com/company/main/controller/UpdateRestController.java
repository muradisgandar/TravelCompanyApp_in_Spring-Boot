/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.controller;

import com.company.main.entities.Travelpackages;
import com.company.main.services.TravelPackagesServiceInter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author murad_isgandar
 */
@RestController
@RequestMapping("getData")
public class UpdateRestController {

    @Autowired
    TravelPackagesServiceInter travelPackagesServiceInter;

    @GetMapping("/packet/{id}")
    public Map<String, Object> packet(@PathVariable(value = "id") Integer id) {
        Travelpackages t = travelPackagesServiceInter.getById(id);
        Map<String, Object> data = new HashMap<>();

        data.put("countryname", t.getCountryname());
        data.put("date", t.getDate());

        return data;
    }

}
