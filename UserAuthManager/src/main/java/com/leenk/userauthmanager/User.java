/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.userauthmanager;

import java.util.UUID;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Other Leenks
 */
public class User {
    private UUID hashedPassword;
    private String userName;
    private String password;
    
    public User(String userName, String password) {
        this.hashedPassword = UUID.nameUUIDFromBytes(password.getBytes(StandardCharsets.UTF_8));
        this.userName = userName.toLowerCase().trim();
        this.password = password.trim();
    }
    
    public UUID getHashedPassword() {
        return hashedPassword;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getUnHashedPassword() {
        return password;
    }
    
    @Override
    public String toString() {
        return "user: " + hashedPassword + "userNamer: " + userName;
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof User)) return false;
        
        User user = (User) object;
        
        return user.getUserName().equals(this.userName) && user.getHashedPassword().equals(this.hashedPassword);
    }
}
