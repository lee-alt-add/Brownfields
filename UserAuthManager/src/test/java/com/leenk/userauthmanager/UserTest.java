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
        assertTrue("Lincoln".equals(user.getUserName()));
    }
    
    @Test
    void getUserIDNotNull() {
        User user = new User("Lincoln", "Lincoln123");
        assertTrue(user.getUserID() != null);
    }
}
