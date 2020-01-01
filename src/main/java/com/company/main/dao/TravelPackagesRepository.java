/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.dao;

import com.company.main.entities.Travelpackages;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author murad_isgandar
 */
public interface TravelPackagesRepository extends CrudRepository<Travelpackages, Integer> {

    @Query(value = "select t from Travelpackages t where t.countryname=?1 or t.date=?2")
    public List<Travelpackages> getAllByParameters(String countryname, String date);

}
