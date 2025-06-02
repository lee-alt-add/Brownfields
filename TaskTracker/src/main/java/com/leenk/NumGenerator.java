/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

/**
 *
 * @author Other Leenks
 */
public class NumGenerator {
    private int number;
    
    public NumGenerator(int from) {
        this.number = from;
    }
    
    public int generate() {
        number++;
        return number;
    }
    
}
