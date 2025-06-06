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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Other Leenks
 */
public class CreditTest {
    @Test
    void payNullCartTest() {
        PaymentMethod credit = new Credit(null);
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        credit.pay();
        
        String expected = "Cannot process payment. Cart is null";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
    }
    
    @Test
    void payEmptyCartTest() {
        Cart cart = new Cart(new Customer("Lincoln", true));
        PaymentMethod credit = new Credit(cart);
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        credit.pay();
        
        String expected = "Cannot process payment. Cart is empty";
        String result = buffer.toString().trim();
        
        assertEquals(expected, result);
    }
}
