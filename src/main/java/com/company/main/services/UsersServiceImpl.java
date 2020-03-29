/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.services;

import com.company.main.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.main.dao.UsersRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author murad_isgandar
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersServiceInter {

    @Autowired
    UsersRepository userdao;

    @Override
    public List getAllUsers() {
        List<Users> list = (List) userdao.findAll();
        return list;
    }

    @Override
    public int addUserOtherDetails(Users u) {
        Users user = userdao.findUserByUsername(u.getUsername());
        
        user.setName(u.getName());
        user.setSurname(u.getSurname());
        user.setAge(u.getAge());
        user.setGender(u.getGender());
        user.setPhonenumber(u.getPhonenumber());
        user.setMail(u.getMail());
        user.setUsername(u.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
        user.setTourId(u.getTourId());
        
        
        userdao.save(user);
        return user.getId();
    }

    @Override
    public int addUsernameAndPassword(Users u) {
        userdao.save(u);
        return u.getId();
    }

    @Override
    public Users setEnable(Integer id) {
//        Optional<Users> opt = userdao.findById(id);  we don't write this code ,beacuse it throws exception if any parameter is null
//        Users u = opt.get();
        Users u = userdao.findUserById(id);
        if (u.isEnabled()) {
            u.setEnabled(false);//if enable is true ,admin changes it to false so user can't login app
        } else {
            u.setEnabled(true);//if enable is false,admin changes it to true,so he gives access for login to user
        }
        userdao.save(u);

        return u;
    }

}
