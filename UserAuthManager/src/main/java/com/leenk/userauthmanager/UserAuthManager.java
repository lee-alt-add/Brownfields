/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.leenk.userauthmanager;

import com.leenk.userauthmanager.storage.*;
import com.leenk.userauthmanager.storage.Storage;

/**
 *
 * @author Other Leenks
 */
public class UserAuthManager {
    private User user;
    private Storage db;
    
    public UserAuthManager(StorageType storageType) {
        db = storageType.equals(StorageType.MEMORY) ?  new InMemory() : new FileStorage();
    }
    
    public void changeDBType(StorageType storageType) {
        switch (storageType) {
            case StorageType.MEMORY -> toMemory();
            case StorageType.FILE -> toFileStorage();
            default -> System.out.println("Invalid memory type");
        }
    }
    
    public StorageType getDBType() {
        return db instanceof InMemory ? StorageType.MEMORY : StorageType.FILE;
    }
    
    public User register(String name, String password) {
        user = db.save(new User(name, password));
        
        if (user == null) System.out.println(name + " already exists. try to login");
        else System.out.println(name + " has been registered.");
        
        return user;
    }
    
    public User login(String name, String password) {
        User user = db.retrieve(name, password);
        
        if (user == null) System.out.println("User does not exist. Register first.");
        else System.out.println("Welcome " + name);
        
        return user;
    }
    
    private void toMemory() {
        Storage db2 = new InMemory();
        db.retrieveAll().stream().forEach(i -> db2.save(i));
        db = db2;
    }
    
    private void toFileStorage() {
        Storage db2 = new FileStorage();
        db.retrieveAll().stream().forEach(i -> db2.save(i));
        db = db2;
    }
}
