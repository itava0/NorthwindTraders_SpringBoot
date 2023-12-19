package org.pluralsight.northwindtradersspringboot.dao;

import org.pluralsight.northwindtradersspringboot.model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getAll();
}
