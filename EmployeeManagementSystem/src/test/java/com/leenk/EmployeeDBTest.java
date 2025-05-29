/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Other Leenks
 */
public class EmployeeDBTest {
    private EmployeeManagementSystem system;
    
    @Test
    void addNullEmployeeTest() {
        system = new EmployeeManagementSystem();
        assertThrows(IllegalArgumentException.class, () -> system.addEmployee(null));
    }
    
    @Test
    void addExistingEmployeeTest() {
        system = new EmployeeManagementSystem();
        Employee em1 = new Employee("Nokuthula", 38, Department.MANAGEMENT);
        Employee em2 = new Employee("Nokuthula", 38, Department.MANAGEMENT);
        system.addEmployee(em1);
        system.addEmployee(em2);
        assertEquals(1, system.getAllEmployees().size());
    }
    
    @Test
    void employeeExistTest() {
        Employee em1 = new Employee("Nokuthula", 38, Department.MANAGEMENT);
        Employee em2 = new Employee("David", 61, Department.FINANCE);
        system = new EmployeeManagementSystem();
        system.addEmployee(em1);
        assertTrue(system.employeeExists(em1));
        assertFalse(system.employeeExists(em2));
    }
}
