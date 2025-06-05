package com.leenk;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Lincoln", true);
        
        Cart cart = new Cart(customer1);
        
        List<Product> lGoogs = List.of(new Product("Cake", 139.99, 1),
                new Product("Ballon", 25.00, 10),
                new Product("Decoration", 250.00, 1));
        
        cart.add(lGoogs);
        
        // Making Payments
        ProcessPayment.process(cart, "cash");
        
        System.out.println("\n\n\n");
        cart.getCustomer().setLoyalty(false);
        
        ProcessPayment.process(cart, "credit");
    }
}
