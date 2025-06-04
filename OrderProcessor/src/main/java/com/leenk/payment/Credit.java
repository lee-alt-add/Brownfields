/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.payment;

import com.leenk.Cart;
import com.leenk.helpers.Helpers;

/**
 *
 * @author Other Leenks
 */
public class Credit implements PaymentMethod{
    private Cart cart;
    
    public Credit(Cart cart) {
        this.cart = cart;
    }
    
    @Override
    public void pay() {
        ShowPaymentDetails show = new ShowPaymentDetails();
        if (Helpers.isNull(cart, "Cannot process payment. Cart is null")) {
            return;
        }
        if (cart.getOrders().isEmpty()) {
            System.out.println("Cannot process payment. Cart is empty");
            return;
        }
        
        System.out.println("Processing cash payment...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            System.out.println("Could not sleep... " + e.getMessage());
        }
        show.of(cart);
    }
}
