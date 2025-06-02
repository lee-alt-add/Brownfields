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
public class NumGeneratorTest {
    @Test
    void generateTest() {
        NumGenerator number = new NumGenerator(0);
        assertEquals(1, number.generate());
        assertEquals(2, number.generate());
    }
}
