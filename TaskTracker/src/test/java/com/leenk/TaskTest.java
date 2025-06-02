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
public class TaskTest {
    @Test
    void getTaskTest() {
        Task task = new Task("Cook");
        task.setTaskNumber(1);
        assertTrue("cook".equals(task.getTask()));
    }
    
    @Test
    void getTaskNoTest() {
        Task task = new Task("Cook");
        task.setTaskNumber(1);
        assertEquals(1, task.getTaskNumber());
    }
    
    @Test
    void equalsTest() {
        Task task = new Task("Cook");
        task.setTaskNumber(1);
        Task newTask = new Task("Walk");
        newTask.setTaskNumber(2);
        
        assertTrue(task.equals(task));
        assertFalse(newTask.equals(task));
    }
}
