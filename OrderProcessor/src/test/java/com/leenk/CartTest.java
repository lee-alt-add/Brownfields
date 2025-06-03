/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Other Leenks
 */
public class CartTest {
    private Cart cart;
    private Customer customer;
    private Product prod1;
    private Product prod2;
    
    @BeforeEach
    void setup(){
        customer = new Customer("Leenk", true);
        cart = new Cart(customer);
        prod1 = new Product("Book", 10.00, 10);
        prod2 = new Product("Pens", 5.00, 2);
        cart.add(List.of(prod1, prod2));
    }
    
    @Test
    void getCustomerNameTest(){
        assertEquals(customer, cart.getCustomer());
    }
    
    @Test
    void addTest() {
        cart.add(new Product("Stapler", 30, 1));
        assertEquals(3, cart.getOrders().size());
    }
    
    @Test
    void removeTest() {
        cart.remove(prod1);
        assertEquals(1, cart.getOrders().size());
    }
    
    @Test
    void removeMultipleTest() {
        cart.remove(List.of(prod1, prod2));
        assertEquals(0, cart.getOrders().size());
    }
    
    @Test
    void getTotalCostTest() {
        assertEquals(126.50, cart.getTotalCost());
    }
}
