/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.dao;

import com.company.main.entities.Travelpackages;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author murad_isgandar
 */
public interface TravelPackagesRepository extends JpaRepository<Travelpackages, Integer>, TravelPackagesRepositoryCustom {
    
    
    
}
