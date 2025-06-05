/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.userauthmanager.storage;

import com.leenk.userauthmanager.User;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author Other Leenks
 */
public class FileStorage implements Storage {
    String filePath = "src/main/resources/users.txt";
    private File file = new File(filePath);
    
    public FileStorage() {}
    
    public void save(User user) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(user.getUserName() + "=" + user.getUserID() + "\n");
        } catch (IOException e) {
            System.out.println("Failed to write to file: " + e.getMessage());
        }
    }
    
    public User retrieve(String name, String password) {
        if (name.isEmpty() || password.isEmpty()) return null;
        User user = new User(name, password);
        if (validate(user)) return user;
        return new User(name, password);
    }
    
    public boolean validate(User user) {
        boolean userExists = false;
        try {
            userExists = Files.lines(Paths.get(filePath))
                    .anyMatch(i -> i.split("=")[0].equals(user.getUserName()) &&
                            i.split("=")[1].equals(user.getUserID().toString())
                    );
        } 
        catch (IOException e) {
            System.out.println("Failed to reading to file: " + e.getMessage());
        }
        return userExists;
    }
}
