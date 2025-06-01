/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.leenk.shoppingcart;

import java.util.List;

/**
 *
 * @author Other Leenks
 */
public class ShoppingCart {

    public static void main(String[] args) {
        Product milk = new Product("Milk", 15.00, 1);
        Product bread = new Product("Bread", 19.00, 1);
        Product eggs = new Product("Milk", 43.00, 1);
        Product chocolate = new Product("Chocolate", 23.00, 3);
        
        Cart cart = new Cart();
        cart.addItems(List.of(milk,bread,eggs,chocolate));
        
        Payment payment = new Payment(cart);
        payment.getReceipt();
    }
}
