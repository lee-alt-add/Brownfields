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
    void addItemTest() {
        Cart cart = new Cart();
        Product product = new Product("Lays", 22.00, 35);
        cart.addProduct(product);
        assertEqauls(1, cart.getItems().length());
    }
    
    @Test
    void addItemFailedTest() {
        Cart cart = new Cart();
        Product product = null;
        cart.addProduct(product);
        assertEqauls(0, cart.getItems().length());
    }
    
    @Test
    void removeItemTest() {
        Cart cart = new Cart();
        Product product = new Product("Lays", 22.00, 35);
        cart.addProduct(product);
        assertEqauls(1, cart.getItems().length());
        cart.removeItem(product);
        assertEquals(0, cart.getItems().length());
    }
    
    @Test
    void getTotalCostTest() {
        Cart cart = new Cart();
        Product product = new Product("Lays", 22.00, 2);
        Product product1 = new Product("Chocolate", 26.00, 1);
        cart.addProduct(product);
        cart.addProduct(product1);
        assertEqauls(70.00, cart.getTotalCost());
    }
}
