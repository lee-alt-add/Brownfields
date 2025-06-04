/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import com.leenk.helpers.Helpers;

/**
 *
 * @author Other Leenks
 */
public class Product {
    private String name;
    private double price;
    private int quantity;
    
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName() {
        return name;
    }
    
    public double getTotalCost() {
        return price * quantity;
    }
    
    public double getDiscount() {
        if (Helpers.isNegative(price)) return -1;
        
        return getTotalCost() * 5/100;
    }
    
    public double getTax() {
        if (Helpers.isNegative(price)) return -1;
        
        return getTotalCost() * 15/100;
    }
}
