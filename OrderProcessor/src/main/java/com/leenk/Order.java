/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Other Leenks
 */
public class Order {
    private Map<Product, Integer> items = new HashMap<>();
    
    public Order() {}
    
    public Map<Product, Integer> getItems() {
        return items;
    }
    
    public void placeOrder(Product product, int quantity) {
        if (isNull(product)) return;
        if (quantity <= 0) return;
        items.put(product, quantity);
    }
    
    public int getQuantity(Product product) {
        if (isNull(product)) return -1;
        
        return items.get(product);
    }
    
    public double getTotalOrderCostOf(Product product) {
        if (isNull(product)) return -1;
        
        return product.getPrice() * items.get(product);
    }
    
    public boolean isNull(Object obj) {
        if (obj == null) {
            System.out.println("Object cannot be null");
            return true;
        }
        return false;
    }
}
