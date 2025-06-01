/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import com.leenk.shoppingcart.Cart;
import com.leenk.shoppingcart.Payment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Other Leenks
 */
public class PaymentTest {
    @Test
    void getCartTest() {
        Cart cart = new Cart();
        Payment pay = new Payment(cart);
        
        assertEquals(cart, pay.getCart());
    }
    
}
