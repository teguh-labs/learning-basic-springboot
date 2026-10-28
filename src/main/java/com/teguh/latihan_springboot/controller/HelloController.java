package com.teguh.latihan_springboot.controller;

import com.teguh.latihan_springboot.model.Product;
import com.teguh.latihan_springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private ProductRepository productRepository; // Inject interface repository JPA

    //1. GET ALL PRODUK DARI DATABASE
    @GetMapping("/produk")
    public List<Product> getAllProduct(){
        return productRepository.findAll(); // Bawaan JPA: SELECT * FROM tb_produk
    }

    //2. SIMPAN PRODUK BARU KE DATABASE
    @PostMapping("/produk")
    public Map<String, Object> tambahProduk(@RequestBody Product product){
        Product produkTersimpan = productRepository.save(product); // Bawaan JPA: INSERT INTO tb_produk

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Produk berhasil disimpan ke MySQL!");
        response.put("data_produk", produkTersimpan);

        return response;
    }

}
