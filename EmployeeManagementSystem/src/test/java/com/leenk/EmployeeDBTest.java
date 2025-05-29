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
    private EmployeeDatabase db;
    
    @Test
    void addNullEmployeeTest() {
        db = new EmployeeDatabase();
        assertThrows(IllegalArgumentException.class, () -> db.addEmployee(null));
    }
    
    @Test
    void addExistingEmployeeTest() {
        db = new EmployeeDatabase();
        Employee em1 = new Employee("Nokuthula", 38, Department.MANAGEMENT);
        Employee em2 = new Employee("Nokuthula", 38, Department.MANAGEMENT);
        db.addEmployee(em1);
        db.addEmployee(em2);
        assertEquals(1, db.getAllEmployees().size());
    }
    
    @Test
    void employeeExistTest() {
        db = new EmployeeDatabase();
        Employee em1 = new Employee("Nokuthula", 38, Department.MANAGEMENT);
        Employee em2 = new Employee("David", 61, Department.FINANCE);
        db.addEmployee(em1);
        assertTrue(db.employeeExists(em1));
        assertFalse(db.employeeExists(em2));
    }
    
    @Test
    void removeEmployeeTestOne() {
        db = new EmployeeDatabase();
        Employee em1 = new Employee("Nokuthula", 38, Department.MANAGEMENT);
        Employee em2 = new Employee("David", 61, Department.FINANCE);
        db.addEmployee(em1);
        db.addEmployee(em2);
        assertEquals(2, db.getAllEmployees().size());
        
        db.removeEmployee(em1);
        assertFalse(db.employeeExists(em1));
        assertEquals(1, db.getAllEmployees().size());
    }
    
    @Test
    void removeNullEmployeeTest() {
        db = new EmployeeDatabase();
        assertThrows(IllegalArgumentException.class,() -> db.removeEmployee(null));
    }
}
