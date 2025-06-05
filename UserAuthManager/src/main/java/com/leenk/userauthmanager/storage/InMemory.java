/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.userauthmanager.storage;

import com.leenk.userauthmanager.User;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author Other Leenks
 */
public class InMemory implements Storage {
    private List<User> users = new ArrayList<>();
    
    public InMemory() {}
    
    public void save(User user) {
        if (user == null) return;
        if (validate(user)) return;
        users.add(user);
    }
    
    public User retrieve(String name, String password) {
        if (name.isEmpty() || password.isEmpty()) return null;
        
        User user = new User(name, password);
        
        if (validate(user)) return user;
        
        else return null;
        
    }
    
    public boolean validate(User user) {
        return users.stream().anyMatch(i -> i.equals(user));
    }
}
