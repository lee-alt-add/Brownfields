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
    
    @Test
    void employeeInfoTest() {
        Employee em1 = new Employee("Simon", 21, Department.ADMIN);
        String expected = "Name: Simon, Age: 21, Department: ADMIN";
        assertEquals(expected, em1.toString());
    }
    
    @Test
    void employeeEqualTest() {
        Employee em1 = new Employee("Simon", 21, Department.ADMIN);
        Employee em2 = new Employee("Simon", 21, Department.ADMIN);
        Employee em3 = new Employee("Sharon", 28, Department.FINANCE);
        assertTrue(em1.equals(em1), "Employee should be same as self");
        assertTrue(em1.equals(em2), "Employee details should match");
        assertFalse(em1.equals(em3));
    }
}
