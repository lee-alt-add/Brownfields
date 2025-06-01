/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import com.leenk.shoppingcart.Cart;
import com.leenk.shoppingcart.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Other Leenks
 */
public class CartTest {
    @Test
    void getTaxTest() {
        Cart cart = new Cart();
        assertEquals(15.00, cart.getTax());
    }
    
    @Test
    void addItemTest() {
        Cart cart = new Cart();
        Product product = new Product("Lays", 22.00, 35);
        cart.addItem(product);
        assertEquals(1, cart.getItems().size());
    }
    
    @Test
    void addItemFailedTest() {
        Cart cart = new Cart();
        Product product = null;
        cart.addItem(product);
        assertEquals(0, cart.getItems().size());
    }
    
    @Test
    void removeItemTest() {
        Cart cart = new Cart();
        Product product = new Product("Lays", 22.00, 35);
        cart.addItem(product);
        assertEquals(1, cart.getItems().size());
        cart.removeItem(product);
        assertEquals(0, cart.getItems().size());
    }
    
    @Test
    void removeItemFailedTest() {
        Cart cart = new Cart();
        Product product = new Product("Lays", 22.00, 35);
        cart.addItem(product);
        cart.removeItem(null);
        assertEquals(1, cart.getItems().size());
    }
    
    @Test
    void getTotalCostTest() {
        Cart cart = new Cart();
        Product product = new Product("Lays", 22.00, 2);
        Product product1 = new Product("Chocolate", 26.00, 1);
        cart.addItem(product);
        cart.addItem(product1);
        double expected = 70.00 + 10.5;
        assertEquals(expected, cart.getTotalCost());
    }
}
