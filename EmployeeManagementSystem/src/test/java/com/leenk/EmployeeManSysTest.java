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
    EmployeeDatabase db = new EmployeeDatabase();
    Employee employee = new Employee("Nokuthula", 38, Department.MANAGEMENT);
    View view = new View();
    EmployeeManagementSystem ems = new EmployeeManagementSystem(db, view);
    
    
    
    @Test
    void getEmployee() {
        db.addEmployee(employee);
        assertEquals(employee, ems.getEmployee(employee));
        db.clearDatabase();
    }
    
    @Test
    void getNullEmployee() {
        assertThrows(NullPointerException.class, () -> ems.getEmployee(null));
    }
    
    @Test
    void showNullEmployeeInfo() {
        assertThrows(NullPointerException.class, () -> ems.showEmployeeInfo(null));
    }
}
