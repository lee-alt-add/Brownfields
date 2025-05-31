/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.shoppingcart;

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
    
    // Setters
    public void setPrice(double price) {
        if (price < 0.00) {
            System.out.println("Price cannot be be negative");
            return;
        }
        this.price = price;
    }
    
    public void setQuantity(int quantity) {
        if (price < 0.00) {
            System.out.println("Price cannot be be negative");
            return;
        }
        this.quantity = quantity;
    }
    
    
    // Getters
    
    public String getName() {
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
}
