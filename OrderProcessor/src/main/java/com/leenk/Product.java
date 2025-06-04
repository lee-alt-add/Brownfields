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
    
    public double getBeforeTaxPrice() {
        return price * quantity;
    }
    
    public double getAfterTaxPrice() {
        return (price + getTaxAmount(price)) * quantity;
    }
    
    public double getDiscountPrice() {
        return getAfterTaxPrice() - getDiscountAmount(getAfterTaxPrice());
    }
    
    public double getDiscountAmount(double price) {
        if (Helpers.isNegative(price)) return -1;
        
        return price * 5/100;
    }
    
    public double getTaxAmount(double price) {
        if (Helpers.isNegative(price)) return -1;
        
        return price * 15/100;
    }
}
