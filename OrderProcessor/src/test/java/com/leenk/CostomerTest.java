/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Other Leenks
 */
public class CostomerTest {
    @Test
    void getNameTest() {
        Customer customer = new Customer("Frank", true);
        assertTrue("Frank".equals(customer.getName()));
    }
    
    @Test
    void setLoyaltyNullTest() {
        Customer customer = new Customer("Frank", true);
        customer.setLoyalty(false);
        assertFalse(customer.isLoyal());
        
    }
    
}
