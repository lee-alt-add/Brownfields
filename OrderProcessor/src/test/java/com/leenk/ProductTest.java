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
        assertTrue(40.00 == product.getBeforeTaxPrice());
    }
    
    @Test
    void getPriceWithTaxTest() {
        assertEquals(46.00, product.getAfterTaxPrice());
    }
    
    @Test
    void getDiscountAmountTest() {
        double totalCost = product.getAfterTaxPrice();
        double discount = product.getDiscountAmount(totalCost);
        assertEquals(2.30, discount);
    }
    
    @Test
    void getDiscountNegativeAmountTest() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        double discount = product.getDiscountAmount(-17.00);
        
        String expected = "number cannot be negative";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
        assertEquals(-1, discount);
    }
    
    @Test
    void getTaxAmountTest() {
        double totalCost = product.getBeforeTaxPrice();
        double discount = product.getTaxAmount(totalCost);
        assertEquals(6.00, discount);
    }
    
    @Test
    void getTaxNegativeAmountTest() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        double tax = product.getTaxAmount(-17.00);
        
        String expected = "number cannot be negative";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
        assertEquals(-1, tax);
    }
}
