/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.services;

import com.company.main.entities.Travelpackages;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.main.dao.TravelPackagesRepository;
import javax.transaction.Transactional;

/**
 *
 * @author murad_isgandar
 */
@Service
@Transactional
public class TravelPackagesServiceimpl implements TravelPackagesServiceInter {

    @Autowired
    TravelPackagesRepository travelPackagesDao;

    @Override
    public Travelpackages getById(Integer id) {
        Travelpackages t = travelPackagesDao.findById(id).get();
        return t;
    }

    @Override
    public List<Travelpackages> getAll() {
        List<Travelpackages> result = (List) travelPackagesDao.findAll();
        return result;
    }

    @Override
    public List<Travelpackages> getAllByParameters(String countryname, String date) {
        List<Travelpackages> result = travelPackagesDao.getAllByParameters(countryname, date);
        return result;
    }

    @Override
    public boolean update(Travelpackages t, Integer id) {

        Travelpackages packet = travelPackagesDao.findById(id).get();

        packet.setCountryname(t.getCountryname());
        packet.setDate(t.getDate());
        travelPackagesDao.save(packet);
        return true;
    }

    @Override
    public boolean add(Travelpackages t) {
        travelPackagesDao.save(t);
        return true;
    }

    @Override
    public boolean delete(int id) {
        travelPackagesDao.deleteById(id);
        return true;
    }

}
