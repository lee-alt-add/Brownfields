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
public class ViewTest {
    @Test
    void showOnTerminalNull() {
        View view = new View();
        assertThrows(NullPointerException.class, view.showOnTerminal(null));
    }
    
    @Test
    void showOnTerminalTest() {
        View view = new View();
        assertThrows(IllegalArgumentException.class, view.showOnTerminal("Hello"));
    }
}
