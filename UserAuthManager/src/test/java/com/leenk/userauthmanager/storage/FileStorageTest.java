/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.userauthmanager.storage;

import com.leenk.userauthmanager.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Other Leenks
 */
public class FileStorageTest {
    @Test
    void saveAndRetrieveTest() {
        FileStorage db = new FileStorage();
        User user1 = new User("Lindo", "Maximum100");
        User user2 = new User("Hloni", "Minimum1");
        
        db.save(user1);
        db.save(user2);
        assertEquals(user1, db.retrieve("Lindo", "Maximum100"));
        assertEquals(user2, db.retrieve("Hloni", "Minimum1"));
        db.clear();
    }
    
    @Test
    void saveAndRetrieveAllTest() {
        FileStorage db = new FileStorage();
        User user1 = new User("Lindo", "Maximum100");
        User user2 = new User("Hloni", "Minimum1");
        
        db.save(user1);
        db.save(user2);
        assertEquals(2, db.retrieveAll().size());
        assertFalse(db.retrieveAll().stream().anyMatch(i -> i == null));
        db.clear();
    }
}
