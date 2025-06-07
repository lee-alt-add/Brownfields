/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.userauthmanager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Other Leenks
 */
public class UAMTest {
    @Test
    void dbTest() {
        UserAuthManager manager1 = new UserAuthManager(StorageType.MEMORY);
        UserAuthManager manager2 = new UserAuthManager(StorageType.FILE);
        assertEquals(manager1.getDBType(), StorageType.MEMORY);
        assertEquals(manager2.getDBType(), StorageType.FILE);
    }
    
    @Test
    void registerTest() {
        UserAuthManager manager = new UserAuthManager(StorageType.MEMORY);
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        User user = manager.register("Lindo", "Maximum100");
        
        String expected = "Lindo has been registered.";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
        assertTrue(user != null);
    }
    
    @Test
    void registerTest2() {
        UserAuthManager manager = new UserAuthManager(StorageType.MEMORY);
        
        manager.register("Lindo", "Maximum100");
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        User user = manager.register("Lindo", "Maximum100");
        
        String expected = "Lindo already exists. try to login";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
        assertTrue(user == null);
    }
    
    @Test
    void loginTest() {
        UserAuthManager manager = new UserAuthManager(StorageType.MEMORY);
        
        manager.register("Lindo", "Maximum100");
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        User user = manager.login("Lindo", "Maximum100");
        
        String expected = "Welcome Lindo";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
        assertTrue(user != null);
    }
    
    @Test
    void loginTest2() {
        UserAuthManager manager = new UserAuthManager(StorageType.MEMORY);
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        User user = manager.login("Lindo", "Maximum100");
        
        String expected = "User does not exist. Register first.";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
        assertTrue(user == null);
    }
}
