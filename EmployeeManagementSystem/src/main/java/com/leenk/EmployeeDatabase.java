/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Other Leenks
 */
public class EmployeeDatabase {
    private List<Employee> allEmployees;
    
    public EmployeeDatabase() {
        allEmployees = new ArrayList<>();
    }
    
    public List<Employee> getAllEmployees() {
        return allEmployees;
    }
    
    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException();
        }
        
        if (employeeExists(employee)) {
            System.out.println("Employee already exist");
            return;
        }
        
        allEmployees.add(employee);
    }
    
    public boolean employeeExists(Employee employee) {
        return allEmployees.stream().anyMatch(e -> e.equals(employee));
    }
}
