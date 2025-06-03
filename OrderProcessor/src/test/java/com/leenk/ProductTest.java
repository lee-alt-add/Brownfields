/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Other Leenks
 */
public class ProductTest {
    private Product product;
    
    @BeforeEach
    void setup() {
        product = new Product("Book", 10.00);
    }
    
    @Test
    void getNameTest() {
        assertTrue("Book".equals(product.getName()));
    }
    
    @Test
    void getPriceTest() {
        assertTrue(10.00 == product.getPrice());
    }
    
    @Test
    void getPriceWithTaxTest() {
        assertEquals(11.50, product.getPriceWithTax());
    }
}
