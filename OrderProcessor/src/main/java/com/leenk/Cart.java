/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import com.leenk.helpers.Helpers;
import java.util.ArrayList;
import java.util.List;

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
    
    private double applyDiscount(double amount) {
        return amount - (amount * 5/100);
    }
    
    public double getTotalCost(){
        if (orders.isEmpty()) return 0.00;
        double cost = orders.stream().mapToDouble(i -> i.getAfterTaxPrice()).sum();
        
        if (customer.isLoyal()){
            return applyDiscount(cost);
        }
        else {
            return cost;
        }
    }
    
}
