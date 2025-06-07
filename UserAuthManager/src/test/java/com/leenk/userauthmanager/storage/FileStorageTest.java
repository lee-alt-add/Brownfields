/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.userauthmanager.storage;

import com.leenk.userauthmanager.User;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

/**
 *
 * @author Other Leenks
 */
public class FileStorageTest {
    private FileStorage db;
    private User user1;
    private User user2;
    
    @BeforeEach
    void setup() {
        db = new FileStorage();
        user1 = new User("Lindo", "Maximum100");
        user2 = new User("Hloni", "Minimum1");
        
        db.save(user1);
        db.save(user2);
    }
    
    @Test
    void saveAndRetrieveTest() {
        assertEquals(user1, db.retrieve("Lindo", "Maximum100"));
        assertEquals(user2, db.retrieve("Hloni", "Minimum1"));
    }
    
    @Test
    void saveAndRetrieveAllTest() {
        List<User> users = db.retrieveAll();
        assertEquals(2, users.size());
        assertFalse(users.stream().anyMatch(i -> i == null));
        assertEquals(user1, users.getFirst());
    }
}
