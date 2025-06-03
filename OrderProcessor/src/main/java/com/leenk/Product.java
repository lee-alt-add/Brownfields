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
    private double priceWithTax;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.priceWithTax = price + (price * 15/100);
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getPriceWithTax() {
        return priceWithTax;
    }
}
