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
public class Cash implements PaymentMethod{
    private Cart cart;
    
    public Cash(Cart cart) {
        this.cart = cart;
    }
    
    @Override
    public void pay() {
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
        showDetails(cart);
    }
    
    private void showDetails(Cart cart) {
        
        System.out.println(
                "Order processed successfully!\n" +
                "Customer Name: " + cart.getCustomer().getName() + "\n" +
                "Items:\n" +
                "----------");
        cart.getOrders()
                .stream()
                .forEach(i -> System.out.println("- " + i.getName() + " R" + i.getTotalCost()));
        
        System.out.println("Total Cost: R" + cart.getOrderDetails().get("cost") + "\n" +
                "Tax: R" + cart.getOrderDetails().get("tax") + "\n"+
                "Discount: R" + cart.getOrderDetails().get("discount") + "\n" +
                "Final Cost: R" + cart.getOrderDetails().get("finalCost"));
    }
}
