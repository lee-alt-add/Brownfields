/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.shoppingcart;

/**
 *
 * @author Other Leenks
 */
public class Payment {
    private Cart cart;
    
    public Payment(Cart cart) {
        this.cart = cart;
    }
    
    public Cart getCart() {
        return cart;
    }
    
    public void getReceipt() {
        cart.getItems()
                .stream()
                .forEach(i -> System.out.println(i.getQuantity() + " x " + i.getName() + " @ " + i.getPrice()));
        System.out.println("\nTotal (with tax): $" + cart.getTotalCost());
        
    }
}
