/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.userauthmanager;

import java.util.UUID;

/**
 *
 * @author Other Leenks
 */
public class User {
    private UUID userID;
    private String userName;
    private String password;
    
    public User(String userName, String password) {
        this.userID = UUID.randomUUID();
        this.userName = userName;
        this.password = password;
    }
    
    public UUID getUserID() {
        return userID;
    }
    
    public String getUserName() {
        return userName;
    }
}
