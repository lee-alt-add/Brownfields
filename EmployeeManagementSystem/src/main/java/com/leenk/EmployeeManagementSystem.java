/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.leenk;

import java.util.stream.Collectors;


/**
 *
 * @author Other Leenks
 */
public class EmployeeManagementSystem {

    private final EmployeeDatabase db;
    private final View view;
    
    public EmployeeManagementSystem(EmployeeDatabase db, View view) {
        this.db = db;
        this.view = view;
    }
    
    public Employee getEmployee(Employee employee) {
        if (!isNull(employee) && db.employeeExists(employee)) {
            return db.getAllEmployees().stream()
                    .filter(e -> e == employee)
                    .collect(Collectors.toList())
                    .getFirst();
        }
        
        System.out.println("Could not find employee");
        return null;
    }
    
    public void showEmployeeInfo(Employee employee) {
        if (!isNull(employee) && db.employeeExists(employee)) {
            view.showOnTerminal(employee);
        }
    }
    
    public void showAllEmployees() {
        view.showOnTerminal(db.getAllEmployees());
    }
    
    public static boolean isNull(Object object) {
        if (object == null) {
            throw new NullPointerException("Input cannot be null");
        }
        return false;
    }
}
