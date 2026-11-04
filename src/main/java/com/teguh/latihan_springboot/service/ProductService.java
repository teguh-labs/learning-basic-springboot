package com.teguh.latihan_springboot.service;

import com.teguh.latihan_springboot.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Map<String, Object> addProduct(Product product);
    Map<String, Object> updateProduct(Long id, Product detailProduct);
    Map<String, Object> deleteProduct(Long id);
}
