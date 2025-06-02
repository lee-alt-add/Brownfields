/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Other Leenks
 */
public class DatabaseTest {
    private Database db;
    
    @BeforeEach
    void setup() {
        db = new Database();
    }
    
    @AfterEach
    void teardown() {
        db.deleteDBFile();
    }
    
    @Test
    void loadTest() throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer, true));
        
        db.loadFile("test.txt");
        
        String result = buffer.toString().trim();
        String expected = "test.txt does not exist. Creating it...\nFile created";
        
        assertEquals(expected, result);
    }
    
    @Test
    void loadExistingFileTest() {
        db.loadFile("tester.txt");
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        db.loadFile("tester.txt");
        
        String expected = "Opened tester.txt file.";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
    }
    
    @Test
    void addTaskTest() {
        db.loadFile("test1.txt");
        db.addTask("Walk the dog");
        assertEquals(1, db.getTasks().size());
    }
    
    @Test
    void addExistingTaskTest() {
        db.loadFile("test2.txt");
        db.addTask("Walk the dog");
        db.addTask("Walk the dog");
        assertEquals(1, db.getTasks().size());
    }
    
    @Test
    void addNullTaskTest() {
        db.loadFile("test3.txt");
        db.addTask(null);
        assertEquals(0, db.getTasks().size());
    }
    
    @Test
    void removeTaskTest() throws IOException {
        db.loadFile("test4.txt");
        db.addTask("Walk the dog");
        assertEquals(1, db.getTasks().size());
        
        db.removeTask("Walk the dog");
        assertEquals(0, db.getTasks().size());
    }
    
    @Test
    void removeNullTaskTest() {
        db.loadFile("test5.txt");
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
        db.loadFile("test6.txt");
        db.addTask("Walk the dog");
        assertEquals(1, db.getTasks().size());
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        db.removeTask("Cook");
        
        String expected = "Invalid task name";
        String result = buffer.toString().trim();
        
        assertEquals(1, db.getTasks().size());
        assertEquals(expected, result);
    }
    
    @Test
    void getTasksTest() {
        db.loadFile("test7.txt");
        db.addTask("Walk the dog");
        assertTrue(db.getTasks().contains("walk the dog"));
    }
}
