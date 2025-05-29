/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import java.util.List;

/**
 *
 * @author Other Leenks
 */
public class View {
    public View() {}
    
    public void showOnTerminal(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        
        if (object instanceof Employee e) {
            System.out.println(e);
        }
        
        try {
            List<Employee> elist = (List<Employee>) object;
            elist.stream().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("List printing error: " + e.getMessage());
            throw new IllegalArgumentException("The input must be an Employee or List of Employees");
        }
    }
}
