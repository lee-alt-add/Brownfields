/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.shoppingcart;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 *
 * @author Other Leenks
 */
public class Cart {
    private List<Product> items;
    private final double tax;
    
    public Cart() {
        items = new ArrayList<>();
        Properties prop = new Properties();
        
        try (InputStream in = Cart.class.getClassLoader().getResourceAsStream("Config.properties")){
            prop.load(in);
        } catch (IOException e) {
            System.out.println("Could not load config file. Tax number set to default 0%");
        }
        tax = Double.parseDouble(prop.getProperty("tax", "0.00"));
        
    }
    
    public List<Product> getItems() {
        return items;
    }
    
    public double getTax() {
        return tax;
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
            return;
        }
        items.remove(product);
    }
    
    public double getTotalCost() {
        return items.stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
    }
}
