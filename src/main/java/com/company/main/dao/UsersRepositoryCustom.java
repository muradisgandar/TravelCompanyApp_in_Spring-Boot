/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.dao;

import com.company.main.entities.Users;
import java.util.List;

/**
 *
 * @author murad_isgandar
 */
public interface UsersRepositoryCustom {
    
    public int addUserOtherDetails(Users u);

    public int addUsernameAndPassword(Users u);
    
    

}
