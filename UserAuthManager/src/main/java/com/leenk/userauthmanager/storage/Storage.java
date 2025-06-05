/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leenk.userauthmanager.storage;

import com.leenk.userauthmanager.User;
import java.util.UUID;

/**
 *
 * @author Other Leenks
 */
public interface Storage {
    void save(User user);
    User retrieve(String name, String password);
    boolean validate(User user);
}
