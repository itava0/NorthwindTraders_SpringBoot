package org.pluralsight.northwindtradersspringboot.dao;

import org.pluralsight.northwindtradersspringboot.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SimpleProductDAO implements ProductDao{

    List<Product> products;

    public SimpleProductDAO() {
        this.products = new ArrayList<>();
        add(new Product(1, "Laptop", "Electronics", 999.99));
        add(new Product(3, "Headphones", "Electronics", 79.99));
        add(new Product(4, "Coffee Maker", "Appliances", 49.99));
        add(new Product(5, "Fitness Tracker", "Fitness", 79.99));
        add(new Product(6, "Bluetooth Speaker", "Electronics", 39.99));
        add(new Product(7, "Digital Camera", "Electronics", 299.99));
        add(new Product(8, "External Hard Drive", "Computers", 89.99));
        add(new Product(9, "Wireless Mouse", "Computers", 19.99));
        add(new Product(10, "Gaming Keyboard", "Computers", 69.99));

    }

    @Override
    public void add(Product product) {
        products.add(product);
    }


    @Override
    public List<Product> getAll() {
        return products;
    }
}
