/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.payment;

import com.leenk.Cart;

/**
 *
 * @author Other Leenks
 */
public class ShowPaymentDetails {
    public ShowPaymentDetails() {}
    
    public void of(Cart cart) {
        
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
