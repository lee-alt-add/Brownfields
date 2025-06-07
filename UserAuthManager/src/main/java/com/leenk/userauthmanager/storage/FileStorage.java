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
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Other Leenks
 */
public class FileStorage implements Storage {
    String filePath = "src/main/resources/users.txt";
    private File file;
    
    public FileStorage() {
        file = new File(filePath);
    }
    
    public User save(User user) {
        if (validate(user)) return null;
        
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(user.getUserName() + "=" + user.getHashedPassword()  + "\n");
        } catch (IOException e) {
            System.out.println("Failed to write to file: " + e.getMessage());
        }
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
    
    public boolean validate(User user) {
        boolean userExists = false;
        try {
            userExists = Files.lines(Paths.get(filePath))
                    .anyMatch(i -> i.split("=")[0].equals(user.getUserName()) &&
                            i.split("=")[1].equals(user.getHashedPassword().toString())
                    );
        } 
        catch (IOException e) {
            System.out.println("Failed to reading to file: " + e.getMessage());
        }
        return userExists;
    }
    
    public void clear() {
        file.delete();
        file = createFile(filePath);
    }
    
    private File createFile(String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.err.println("File not created: " + e.getMessage());
        }
        return file;
    }
}
