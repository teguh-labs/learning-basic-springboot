package com.teguh.latihan_springboot.service;

import com.teguh.latihan_springboot.dto.ProductRequestDTO;
import com.teguh.latihan_springboot.dto.ProductResponseDTO;
import com.teguh.latihan_springboot.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long id);
    Map<String, Object> addProduct(ProductRequestDTO requestDTO);
    Map<String, Object> updateProduct(Long id, ProductRequestDTO requestDTO);
    Map<String, Object> deleteProduct(Long id);
}
