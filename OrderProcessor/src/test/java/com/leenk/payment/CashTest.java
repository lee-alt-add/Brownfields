/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.payment;

import com.leenk.Cart;
import com.leenk.Customer;
import com.leenk.Product;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Other Leenks
 */
public class CashTest {
    @Test
    void payNullCartTest() {
        PaymentMethod cash = new Cash(null);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        cash.pay();
        
        String expected = "Cannot process payment. Cart is null";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
    }
    
    @Test
    void payEmptyCartTest() {
        Cart cart = new Cart(new Customer("Lincoln", true));
        
        PaymentMethod cash = new Cash(cart);
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        cash.pay();
        
        String expected = "Cannot process payment. Cart is empty";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
    }
    
    @Test
    void payTest() {
        Cart cart = new Cart(new Customer("Lincoln", true));
        cart.add(new Product("Pensil", 5.00, 10));
        
        PaymentMethod cash = new Cash(cart);
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        cash.pay();
        
        String expected = "Processing cash payment...";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
    }
}
