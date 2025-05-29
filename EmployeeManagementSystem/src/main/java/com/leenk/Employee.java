/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

/**
 *
 * @author Other Leenks
 */
public class Employee {
    private final String name;
    private int age;
    private Department department;
    
    public Employee(String name, int age, Department department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    public Department getDepartment() { return department; }
    
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        
        Employee employee = (Employee) other;
        
        return this.name.equals(employee.getName()) && 
                this.age == employee.getAge() &&
                this.department == employee.getDepartment();
    }
    
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Department: " + department.toString();
    }
}
