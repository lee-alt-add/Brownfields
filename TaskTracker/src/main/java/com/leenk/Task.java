/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk;

/**
 *
 * @author Other Leenks
 */
public class Task {
    private final String task;
    private final int number;
    
    public Task(String task, int number) {
        this.task = task.toLowerCase().trim();
        this.number = number;
    }
    
    public String getTask() {
        return task;
    }
    
    public int getTaskNumber() {
        return number;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) return false;
        
        Task task = (Task) obj;
        return task.getTask().equals(this.task) && task.getTaskNumber() == this.number;
    }
}
