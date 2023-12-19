package org.pluralsight.northwindtradersspringboot.dao;

import org.pluralsight.northwindtradersspringboot.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCustomerDao implements CustomerDao{
    private DataSource dataSource;
    @Autowired
    public JdbcCustomerDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    public List<Customer> getAll(){
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from customers;");){
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    customers.add(new Customer(results.getString("CustomerID"), results.getString("ContactName"),  results.getString("Address")));
                }
            }
        }
        catch (SQLException e){
            System.out.println("An error has occurred in the search");
        }
        return customers;
    }
}

