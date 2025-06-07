/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.userauthmanager.storage;

import com.leenk.userauthmanager.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Other Leenks
 */
public class InMemory implements Storage {
    private List<User> users = new ArrayList<>();
    
    public InMemory() {}
    
    public User save(User user) {
        if (user == null) return null;
        if (validate(user)) return null;
        users.add(user);
        return user;
    }
    
    public User retrieve(String name, String password) {
        if ((name.trim().isEmpty() || name.isBlank()) || 
                (password.trim().isEmpty() || password.isBlank())){
            return null;
        }
        
        User user = new User(name, password);
        
        return validate(user) ? user : null;
        
    }
    
    public List<User> retrieveAll() {
        return users;
    }
    
    public boolean validate(User user) {
        return users.stream().anyMatch(i -> i.equals(user));
    }
}
