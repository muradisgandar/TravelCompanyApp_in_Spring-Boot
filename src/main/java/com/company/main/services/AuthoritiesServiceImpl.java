/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.services;

import com.company.main.dao.AuthoritiesRepository;
import com.company.main.entities.Authorities;
import com.company.main.entities.Users;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author murad_isgandar
 */
@Service
@Transactional
public class AuthoritiesServiceImpl implements AuthoritiesServiceInter {
    
    @Autowired
    AuthoritiesRepository authdao;

    @Override
    public int addAuthority(Users u) {
        Authorities auth = new Authorities();
        
        auth.setAuthority("USER");
        auth.setUser(u);
        
        authdao.save(auth);
        return 0;
    }
    
}
