/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Other Leenks
 */
public class OrderTest {
    private Order order;
    private Product product;
    
    @BeforeEach
    void setup() {
        order = new Order();
        product = new Product("Book", 10.00);
        order.placeOrder(product, 25);
    }
    
    @Test
    void getItemsTest() {
        assertEquals(Map.of(product, 25), order.getItems());
    }
    
    @Test
    void getQuantityTest() {
        assertEquals(25, order.getQuantity(product));
    }
    
    @Test
    void getNullQuantityTest() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        order.getQuantity(null);
        
        String expected = "Object cannot be null";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
    }
    
    @Test
    void getTotalCostTest() {
        assertEquals(250.00, order.getTotalOrderCostOf(product));
    }
    
    @Test
    void getTotalCostNullTest() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        order.getTotalOrderCostOf(null);
        
        String expected = "Object cannot be null";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
    }
}
