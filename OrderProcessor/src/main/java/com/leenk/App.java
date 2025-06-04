package com.leenk;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Lincoln", true);
        Customer customer2 = new Customer("Hloni", false);
        
        Cart cart1 = new Cart(customer1);
        Cart cart2 = new Cart(customer2);
        
        List<Product> lGoogs = List.of(new Product("Cake", 139.99, 1),
                new Product("Ballon", 25.00, 10),
                new Product("Decoration", 250.00, 1));
        
        List<Product> hGoogs = List.of(new Product("Drink", 21.00, 10),
                new Product("TV", 4500.00, 1),
                new Product("DSTV", 700.00, 1));
        
        cart1.add(lGoogs);
        cart2.add(hGoogs);
        
        // Making Payments
        ProcessPayment.process(cart1, "cash");
        
        System.out.println("\n\n\n");
        
        ProcessPayment.process(cart2, "credit");
    }
}
