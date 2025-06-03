/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.helpers;

/**
 *
 * @author Other Leenks
 */
public class Helpers {
    public static boolean isNull(Object obj) {
        if (obj == null) {
            System.out.println("Object cannot be null");
            return true;
        }
        return false;
    }
}
