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
public class Customer {
    private String name;
    private boolean loyal;
    
    public Customer(String name, boolean loyal) {
        this.name = name;
        this.loyal = loyal;
    }
    
    public void setLoyalty(boolean loyal) {
        this.loyal = loyal;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isLoyal() {
        return loyal;
    }
    
}
