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
    void setPriceTest() {
        Product product = new Product("Chocolate", 23.00, 50);
        product.setPrice(27.00);
        assertEquals(27.00, product.getPrice());
    }
    
    @Test
    void setPriceFailedTest() {
        Product product = new Product("Chocolate", 23.00, 50);
        product.setPrice(-27.00);
        assertEquals(23.00, product.getPrice(), "Price negative test failed");
        
        // Test Two
        product.setPrice(null);
        assertEquals(23.00, product.getPrice(), "Price null test failed");
    }
    
    @Test
    void setQuantityTest() {
        Product product = new Product("Chocolate", 23.00, 50);
        product.setQuantity(70);
        assertEquals(70, product.getQuantity());
    }
    
    @Test
    void setQuantityFailedTest() {
        Product product = new Product("Chocolate", 23.00, 50);
        product.setQuantity(-67);
        assertEquals(23.00, product.getPrice(), "Quantity negative test failed");
        
        // Test Two
        product.setQuantity(null);
        assertEquals(23.00, product.getPrice(), "Quantity null test failed");
    }
    
    @Test
    void getNameTest() {
        Product product = new Product("Chocolate", 23.00, 50);
        assertEquals("Chocolate", product.getName());
    }
    
    @Test
    void getPriceTest() {
        Product product = new Product("Chocolate", 23.00, 50);
        assertEquals(23.00, product.getPrice());
    }
    
    @Test
    void getQuantityTest() {
        Product product = new Product("Chocolate", 23.00, 50);
        assertEquals(50, product.getQuantity());
    }
}
