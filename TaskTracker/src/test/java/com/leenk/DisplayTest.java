/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Other Leenks
 */
public class DisplayTest {
    private Display display;
    
    @BeforeEach
    void setup() {
        display = new Display();
    }
    
    @Test
    void showNullTest() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        display.show(null);
        
        String result = buffer.toString().trim();
        String expected = "Object cannot be null";
        
        assertEquals(expected, result);
    }
    
    @Test
    void showInvalidObjectTest() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        display.show(new Task("Walking"));
        
        String result = buffer.toString().trim();
        String expected = "Object not supported";
        
        assertEquals(expected, result);
    }
    
    @Test
    void showEmptyDatabaseTest() {
        Database db = new Database();
        db.loadFile("tester");
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        display.show(db);
        
        String result = buffer.toString().trim();
        String expected = "Database has no tasks";
        
        assertEquals(expected, result);
        db.deleteDBFile();
    }
    
    @Test
    void showTest() {
        Database db = new Database();
        db.loadFile("tester");
        db.addTask("Walk the dog");
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        display.show(db);
        
        String result = buffer.toString().trim();
        String expected = "- 1. walk the dog";
        
        assertEquals(expected, result);
        db.deleteDBFile();
    }
}
