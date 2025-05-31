package com.leenk;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.leenk.shoppingcart.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Other Leenks
 */
public class ProductTest {
    @Test
    void getNameTest() {
        Product product = new Product("Chocolate", 23.00, 50);
        assertEquals("Chocolate", product.getName());
    }
    
    @Test
    void getNameFailedTest() {
        Product product = new Product("Chocolate", 23.00, 50);
        assertEquals(null, product.getName());
    }
    
    @Test
    void getPriceTest() {
        Product product = new Product("Chocolate", 23.00, 50);
        assertEquals(23.00, product.getPrice());
    }
    
    @Test
    void getPriceFailedTest() {
        Product product = new Product("Chocolate", 23.00, 50);
        assertEquals(null, product.getPrice());
    }
    
    @Test
    void getQuantityTest() {
        Product product = new Product("Chocolate", 23.00, 50);
        assertEquals(50, product.getQuantity());
    }
    
    @Test
    void getQuantityFailedTest() {
        Product product = new Product("Chocolate", 23.00, 50);
        assertEquals(null, product.getQuantity());
    }
}
