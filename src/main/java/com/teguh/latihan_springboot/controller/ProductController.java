package com.teguh.latihan_springboot.controller;

import com.teguh.latihan_springboot.dto.ProductRequestDTO;
import com.teguh.latihan_springboot.dto.ProductResponseDTO;
import com.teguh.latihan_springboot.model.Product;
import com.teguh.latihan_springboot.repository.ProductRepository;
import com.teguh.latihan_springboot.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/produk")
    public List<ProductResponseDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/produk/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/produk")
    public Map<String, Object> addProduct(@Valid @RequestBody ProductRequestDTO requestDTO) {
        return productService.addProduct(requestDTO);
    }

    @PutMapping("/produk/{id}")
    public Map<String, Object> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequestDTO requestDTO) {
        return productService.updateProduct(id, requestDTO);
    }

    @DeleteMapping("/produk/{id}")
    public Map<String, Object> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
