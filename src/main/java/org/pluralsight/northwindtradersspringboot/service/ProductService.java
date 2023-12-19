package org.pluralsight.northwindtradersspringboot.service;

import org.pluralsight.northwindtradersspringboot.dao.ProductDao;
import org.pluralsight.northwindtradersspringboot.dao.SimpleProductDAO;
import org.pluralsight.northwindtradersspringboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final SimpleProductDAO productDAO;

    @Autowired
    public ProductService(SimpleProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void addProduct(Product product) {
        productDAO.add(product);
    }

    public List<Product> getAll() {
        return productDAO.getAll();
    }
}
