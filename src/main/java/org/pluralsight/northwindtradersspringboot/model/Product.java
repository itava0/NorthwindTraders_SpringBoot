package org.pluralsight.northwindtradersspringboot.model;
import java.util.Objects;

public class Product {
    private int productId;
    private String name;
    private String Category;
    private double price;

    public Product(int productId, String name, String category, double price) {
        this.productId = productId;
        this.name = name;
        Category = category;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getProductId() == product.getProductId() && Double.compare(getPrice(), product.getPrice()) == 0 && Objects.equals(getName(), product.getName()) && Objects.equals(getCategory(), product.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getName(), getCategory(), getPrice());
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", Category='" + Category + '\'' +
                ", price=" + price +
                '}';
    }
}