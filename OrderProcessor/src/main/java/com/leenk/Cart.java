/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import com.leenk.helpers.Helpers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Other Leenks
 */
public class Cart {
    private Customer customer;
    private List<Product> orders;
    
    public Cart(Customer customer) {
        this.customer = customer;
        orders = new ArrayList<>();
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public List<Product> getOrders() {
        return orders;
    }
    
    // Functional
    
    public void add(Product product) {
        if (Helpers.isNull(product)) return;
        
        orders.add(product);
    }
    
    public void add(List<Product> products) {
        if (Helpers.isNull(products)) return;
        
        products.stream().forEach(i -> add(i));
    }
    
    public void remove(Product product) {
        if (Helpers.isNull(product)) return;
        
        orders.remove(product);
    }
    
    public void remove(List<Product> products) {
        if (Helpers.isNull(products)) return;
        
        products.stream().forEach(i -> remove(i));
    }
    
    // Returnable
    
    public Map<String, Double> getOrderDetails() {
        
        double totalCost = Math.round(getOrders()
                .stream()
                .mapToDouble(i -> i.getTotalCost())
                .sum());
        
        double totalTax = Math.round(getOrders()
                .stream().mapToDouble(i -> i.getTax())
                .sum());
        
        double totalDiscount = getCustomer().isLoyal() ?
                Math.round(getOrders().stream().mapToDouble(i -> i.getDiscount()).sum()) :
                0.00;
        
        double finalCost = totalCost + totalTax - totalDiscount;
        
        return Map.of(
                "cost", totalCost,
                "tax", totalTax,
                "discount", totalDiscount,
                "finalCost", finalCost);
    }
    
}
