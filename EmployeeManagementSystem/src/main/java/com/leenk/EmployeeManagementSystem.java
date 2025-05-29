/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.leenk;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Other Leenks
 */
public class EmployeeManagementSystem {

    private List<Employee> allEmployees;
    
    public EmployeeManagementSystem() {
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
