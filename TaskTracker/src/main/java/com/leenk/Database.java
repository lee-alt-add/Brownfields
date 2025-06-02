/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Other Leenks
 */
public class Database {
    private File file;
    private String filePath;
    
    public Database() {}
    
    public void loadFile(String fileName) {
        filePath = "src/main/resources/" + fileName;
        file = new File(filePath);
        if (file.exists()) {
            System.out.println("Opened " + file.getName() + " file.");
        }
        else {
            try {
                System.out.println(file.getName() + " does not exist. Creating it...\nFile created");
                file.createNewFile();
            } 
            catch (Exception e) {
                System.out.println("Error creating file");
            }
            
        }
    }
    
    public void addTask(String task) {
        if (isNull(task) || taskExists(task)) return;
        
        writeToFile(task);
    }
    
    public void removeTask(String task) {
        if (isNull(task)) return;
        
        if (taskExists(task)) {
            // Getting every task in a list
            List<String> allTasks = new ArrayList<>(getTasks().stream().map(i-> i.getTask()).toList());
            
            allTasks.remove(task.toLowerCase());
            String fileName = file.getName();
            file.delete();
            loadFile(fileName);
            allTasks.stream().forEach(i -> writeToFile(i));
        }
        System.out.println("Invalid task name");
    }
    
    public List<Task> getTasks() {
        List<Task> output = new ArrayList<>();
        NumGenerator number = new NumGenerator(0);
        try {
            Files.lines(Paths.get(filePath))
                    .forEach(i -> output.add(new Task(i).setTaskNumber(number.generate())));
        } 
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return output;
    }
    
    public void deleteDBFile() {
        file.delete();
    }
    
    private void writeToFile(String task) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(task + "\n");
        } 
        catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
    
    private boolean isNull(Object object) {
        if (object == null) {
            System.out.println("Task cannot be null");
            return true;
        }
        return false;
    }
    
    private boolean taskExists(String task) {
        // Getting every task in a list
        List<String> allTasks = getTasks().stream().map(i-> i.getTask()).toList();
        
        if (allTasks.contains(task.toLowerCase())) {
            System.out.println("Task already exists");
            return true;
        }
        return false;
    }
    
}
