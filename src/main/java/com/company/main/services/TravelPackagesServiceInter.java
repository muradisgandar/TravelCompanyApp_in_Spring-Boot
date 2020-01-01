/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.services;

import com.company.main.entities.Travelpackages;
import java.util.List;

/**
 *
 * @author murad_isgandar
 */
public interface TravelPackagesServiceInter {
    public List<Travelpackages> getAll();

    public Travelpackages getById(Integer id);
    
    public List<Travelpackages> getAllByParameters(String countryname,String date);

    public boolean update(Travelpackages t,Integer id);

    public boolean add(Travelpackages t);

    public boolean delete(int id);
    
}
