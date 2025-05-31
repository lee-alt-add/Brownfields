/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.shoppingcart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Other Leenks
 */
public class Cart {
    private List<Product> items;
    
    public Cart() {
        items = new ArrayList<>();
    }
    
    public List<Product> getItems() {
        return items;
    }
    
    public void addItem(Product product) {
        if (product == null) {
            System.out.println("Item cannot be null");
            return;
        }
        items.add(product);
    }
    
    public void removeItem(Product product) {
        if (product == null) {
            System.out.println("Item cannot be null");
        }
        items.remove(product);
    }
    
    public double getTotalCost() {
        return items.stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
    }
}
