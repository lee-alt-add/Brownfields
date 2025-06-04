/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import com.leenk.payment.Cash;
import com.leenk.payment.Credit;
import com.leenk.payment.PaymentMethod;
import com.leenk.payment.ShowPaymentDetails;

/**
 *
 * @author Other Leenks
 */
public class ProcessPayment {
    
    public static void process(Cart cart, String paymentMethod) {
        ShowPaymentDetails show = new ShowPaymentDetails();
        
        if (paymentMethod.toLowerCase().trim().equals("cash")) {
            PaymentMethod cash = new Cash(cart);
            cash.pay();
        }
        else if (paymentMethod.toLowerCase().trim().equals("credit")) {
            PaymentMethod credit = new Credit(cart);
            credit.pay();
        } 
        else {
            System.out.println("Invalid payment method");
        }
    }
}
