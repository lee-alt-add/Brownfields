/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    
    public void removeEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException();
        }
        
        if (!employeeExists(employee)) {
            System.out.println("Employee does not exist");
            return;
        }
        
        allEmployees.remove(employee);
    }
    
    public void removeByName(String employeeName) {
        if (employeeName == null) {
            throw new IllegalArgumentException();
        }
        Employee employee = allEmployees.stream()
                .filter(e -> e.getName().equals(employeeName))
                .collect(Collectors.toList())
                .getFirst();
        
        if (employee == null) {
            System.out.println("Employee does not exist");
            return;
        }
        
        allEmployees.remove(employee);
    }
    
    public void clearDatabase() {
        allEmployees = new ArrayList<>();
    }
}
