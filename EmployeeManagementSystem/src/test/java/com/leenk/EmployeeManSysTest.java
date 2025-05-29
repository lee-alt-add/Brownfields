/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Other Leenks
 */
public class EmployeeManSysTest {
    private EmployeeManagementSystem system;
    @Test
    void employeeExistTest() {
        Employee em1 = new Employee("Nokuthula", 38, Department.MANAGEMENT);
        Employee em2 = new Employee("David", 61, Department.FINANCE);
        system = new EmployeeManagementSystem();
        system.addEmployee(em1);
        assertTrue(system.employeeExist(em1));
        assertFalse(system.employeeExists(em2));
    }
    
    @Test
    void generateEmployeeInfoTest() {
        Employee em1 = new Employee("Simon", 21, Department.ADMIN);
        system = new EmployeeManagementSystem();
        system.addEmployee(em1);
        String expected = "Name: Simon, Age: 21, Department: ADMIN";
        String result = system.generateEmployeeInfo(em1);
        assertEquals(expected, result);
    }
}
