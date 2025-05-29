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
    
    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException();
        }
        allEmployees.add(employee);
    }
}
