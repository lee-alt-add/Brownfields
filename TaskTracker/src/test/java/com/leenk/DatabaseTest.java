/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Other Leenks
 */
public class DatabaseTest {
    @Test
    void loadTest() throws IOException {
        File file = new File("src/test/java/com/leenk/files/test.txt");
        Database db = new Database();
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer, true));
        
        db.loadFile("src/test/java/com/leenk/files/test.txt");
        
        String result = buffer.toString().trim();
        String expected = "test.txt does not exist. Creating it...\nFile created";
        
        assertEquals(expected, result);
        file.delete();
    }
    
    @Test
    void loadExistingFileTest() {
        File file = creatTestFile();
        
        Database db = new Database();
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        db.loadFile("src/test/java/com/leenk/files/test.txt");
        
        String expected = "Opened test.txt file.";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
        file.delete();
    }
    
    @Test
    void addTaskTest() {
        Database db = new Database();
        File file = creatTestFile();
        db.loadFile(file.getAbsolutePath());
        db.addTask("Walk the dog");
        assertEquals(1, db.getTasks().size());
        file.delete();
    }
    
    @Test
    void addExistingTaskTest() {
        Database db = new Database();
        File file = creatTestFile();
        db.loadFile(file.getAbsolutePath());
        db.addTask("Walk the dog");
        db.addTask("Walk the dog");
        assertEquals(1, db.getTasks().size());
    }
    
    @Test
    void addNullTaskTest() {
        Database db = new Database();
        File file = creatTestFile();
        db.loadFile(file.getAbsolutePath());
        db.addTask(null);
        assertEquals(0, db.getTasks().size());
    }
    
    @Test
    void removeTaskTest() throws IOException {
        Database db = new Database();
        File file = creatTestFile();
        db.loadFile(file.getPath());
        db.addTask("Walk the dog");
        assertEquals(1, db.getTasks().size());
        
        db.removeTask("Walk the dog");
        assertEquals(1, db.getTasks().size());
    }
    
    @Test
    void removeNullTaskTest() {
        Database db = new Database();
        File file = creatTestFile();
        db.loadFile(file.getAbsolutePath());
        db.addTask("Walk the dog");
        assertEquals(1, db.getTasks().size());
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        db.removeTask(null);
        
        String expected = "Task cannot be null";
        String result = buffer.toString().trim();
        
        assertEquals(1, db.getTasks().size());
        assertEquals(expected,result);
    }
    
    @Test
    void removeNoneExistingTaskTest() {
        Database db = new Database();
        File file = creatTestFile();
        db.loadFile(file.getAbsolutePath());
        db.addTask("Walk the dog");
        assertEquals(1, db.getTasks().size());
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        db.removeTask("Cook");
        
        String expected = "Task does not exist";
        String result = buffer.toString().trim();
        
        assertEquals(1, db.getTasks().size());
        assertEquals(expected, result);
    }
    
    private File creatTestFile() {
        File file = new File("src/test/java/com/leenk/files/test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return file;
    }
}
