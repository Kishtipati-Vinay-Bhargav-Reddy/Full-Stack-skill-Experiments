package com.examplee;



import com.example.dao.ProductDAO;
import com.example.entity.Product;

public class MainApp {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        // CREATE
        Product p1 = new Product("Laptop", "Dell i7", 75000, 5);
        dao.saveProduct(p1);

        // READ
        Product product = dao.getProductById(p1.getId());
        if (product != null) {
            System.out.println("Product Name: " + product.getName());
        }

        // UPDATE
        product.setPrice(72000);
        dao.updateProduct(product);

        System.out.println("CRUD operations completed.");
    }
}

