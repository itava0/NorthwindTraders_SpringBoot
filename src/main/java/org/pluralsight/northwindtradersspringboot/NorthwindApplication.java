package org.pluralsight.northwindtradersspringboot;

import org.pluralsight.northwindtradersspringboot.dao.JdbcCustomerDao;
import org.pluralsight.northwindtradersspringboot.model.Product;
import org.pluralsight.northwindtradersspringboot.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class NorthwindApplication implements CommandLineRunner {

    ProductService productService;

    JdbcCustomerDao jdbcCustomerDao;

    public NorthwindApplication(ProductService productService, JdbcCustomerDao jdbcCustomerDao) {
        this.productService = productService;
        this.jdbcCustomerDao = jdbcCustomerDao;
    }

    @Override
    public void run(String... args) {

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Display menu and handle user input
        while (true) {
            System.out.println("1. List All Products");
            System.out.println("2. Add Product");
            System.out.println("3. List All Customers");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    listAllProducts(productService);
                    break;
                case 2:
                    addProduct(scanner, productService);
                    break;
                case 3:
                    listAllCustomer(jdbcCustomerDao);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void listAllCustomer(JdbcCustomerDao customerDao) {
        System.out.println("List of All Customers");
        customerDao.getAll().forEach(System.out::println);
    }

    private static void listAllProducts(ProductService productService) {
        // Retrieve and print all products
        System.out.println("List of All Products:");
        productService.getAll().forEach(System.out::println);
    }

    private static void addProduct(Scanner scanner, ProductService productService) {
        // Gather product details from the user
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter product category: ");
        String productCategory = scanner.nextLine();

        System.out.print("Enter product price: ");
        double productPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        // Create a new product
        Product newProduct = new Product(0, productName, productCategory, productPrice);

        // Add the product using the ProductService
        productService.addProduct(newProduct);

        System.out.println("Product added successfully!");
    }
}
