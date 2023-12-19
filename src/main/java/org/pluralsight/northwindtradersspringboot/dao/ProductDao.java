package org.pluralsight.northwindtradersspringboot.dao;

import org.pluralsight.northwindtradersspringboot.model.Product;

import java.util.List;

public interface ProductDao {
    public void add(Product product);
    public List<Product> getAll();
}
