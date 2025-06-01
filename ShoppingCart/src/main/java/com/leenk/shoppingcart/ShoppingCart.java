/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.leenk.shoppingcart;

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
        cart.addItem(milk);
        cart.addItem(bread);
        cart.addItem(eggs);
        cart.addItem(chocolate);
        
        Payment payment = new Payment(cart);
        payment.getReceipt();
    }
}
