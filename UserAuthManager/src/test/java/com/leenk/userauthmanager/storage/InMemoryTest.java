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
public class InMemoryTest {
    @Test
    void saveAndRetrieveTest() {
        InMemory db = new InMemory();
        User user = new User("Lindo", "Lindo123");
        db.save(user);
        assertEquals(user, db.retrieve("Lindo", "Lindo123"));
    }
    
    @Test
    void saveAndRetrieveAllTest() {
        InMemory db = new InMemory();
        User user1 = new User("Lindo", "Maximum100");
        User user2 = new User("Hloni", "Minimum1");
        
        db.save(user1);
        db.save(user2);
        assertEquals(2, db.retrieveAll().size());
        assertFalse(db.retrieveAll().stream().anyMatch(i -> i == null));
    }
}
