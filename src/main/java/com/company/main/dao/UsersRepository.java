/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.dao;

import com.company.main.entities.Users;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author murad_isgandar
 */
public interface UsersRepository extends CrudRepository<Users, Integer>{
    
    public Users findUserByUsername(String username);
    
    public Users findUserById(Integer id);
    
}
