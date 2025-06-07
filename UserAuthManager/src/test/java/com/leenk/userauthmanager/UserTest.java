/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.userauthmanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Other Leenks
 */
public class UserTest {
    @Test
    void getUserName() {
        User user = new User("Lincoln", "Lincoln123");
        assertTrue("lincoln".equals(user.getUserName()));
    }
    
    @Test
    void getUserIDNotNull() {
        User user = new User("Lincoln", "Lincoln123");
        assertTrue(user.getHashedPassword() != null);
    }
    
    @Test
    void getUserEquals() {
        User user = new User("Lincoln", "Lincoln123");
        User user1 = new User("Lincoln", "Lincoln123");
        User user2 = new User("Lincoln", "Liar2020");
        assertTrue(user.equals(user1));
        assertFalse(user.equals(user2));
    }
}
