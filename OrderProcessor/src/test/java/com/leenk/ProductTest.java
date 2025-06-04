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
        product = new Product("Book", 10.00, 4);
    }
    
    @Test
    void getNameTest() {
        assertTrue("Book".equals(product.getName()));
    }
    
    @Test
    void getPriceTest() {
        assertTrue(40.00 == product.getTotalCost());
    }
    
    @Test
    void getPriceWithTaxTest() {
        assertEquals(46.00, product.getTotalCost() + product.getTax());
    }
    
    @Test
    void getDiscountAmountTest() {
        assertEquals(2.00, product.getDiscount());
    }
    
    @Test
    void getTaxAmountTest() {
        assertEquals(6.00, product.getTax());
    }
}
