package com.leenk;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Database db = new Database();
        db.loadFile("tester.txt");
        Display display = new Display();
        
        db.addTask("Walk the dog");
        db.addTask("Go to the gym");
        db.addTask("Cook dinner for two");
        
        display.show(db);
        db.deleteDBFile();
    }
}
