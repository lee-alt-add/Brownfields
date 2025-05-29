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
public class EmpoyeeTest {
    @Test
    void employeeNameTest() {
        Employee employee = new Employee("Nokuthula", 38, Department.MANAGEMENT);
        assertEquals("Nokuthula", employee.getName());
    }
    
    @Test
    void employeeAgeTest() {
        Employee employee = new Employee("Milicent", 23, Department.ADMIN);
        assertEquals(23, employee.getAge());
    }
    
    @Test
    void employeeDepartmentTest() {
        Employee employee = new Employee("Sharon", 28, Department.FINANCE);
        assertEquals(Department.FINANCE, employee.getDepartment());
    }
}
