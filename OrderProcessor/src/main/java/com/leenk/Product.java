/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

/**
 *
 * @author Other Leenks
 */
public class Product {
    private String name;
    private double price;
    private int quantity;
    private double priceWithTax;
    
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.priceWithTax = price + (price * 15/100);
    }
    
    public String getName() {
        return name;
    }
    
    public double getBeforeTaxPrice() {
        return price * quantity;
    }
    
    public double getAfterTaxPrice() {
        return priceWithTax * quantity;
    }
}
