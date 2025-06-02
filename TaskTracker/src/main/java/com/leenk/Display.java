/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

/**
 *
 * @author Other Leenks
 */
public class Display {
    
    public Display() {}
    
    public void show(Object object) {
        if (isNull(object)) return;
        
        if (object instanceof Database db) {
            if (db.getTasks().isEmpty()) {
                System.out.println("Database has no tasks");
            } 
            else {
                db.getTasks()
                        .stream()
                        .forEach(i -> System.out.println("- " +i.getTaskNumber() + ". " + i.getTask()));
            }
        }
        else {
            System.out.println("Object not supported");
        }
    }
    
    private boolean isNull(Object object) {
        if (object == null) {
            System.out.println("Object cannot be null");
            return true;
        }
        return false;
    }
}
