/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.dto;

import com.company.main.entities.Travelpackages;
import lombok.Data;

/**
 *
 * @author murad_isgandar
 */
@Data
public class UserDTO {
    private String name;
    private String surname;
    private Integer age;
    private String gender;
    private String phoneNumber;
    private boolean enabled;
    private String username;
    private String mail;
    private String password;
    private Travelpackages tourId;

    public UserDTO() {
    }

    public UserDTO(String name, String surname, Integer age, String gender, String phoneNumber, boolean enabled, String username, String mail, String password, Travelpackages tourId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.tourId = tourId;
    }


    
    
    
}
