package com.teguh.latihan_springboot.controller;

import com.teguh.latihan_springboot.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public Map<String, String> sayHello(){
        Map<String, String > response = new HashMap<>();
        response.put("message", "Hello welcome to your first REST API Springboot");
        response.put("status", "Success");

        return response;
    }

    @PostMapping("/produk")
    public Map<String, Object> tambahProduk(Product product){
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Produk berhasil ditambahkan");
        response.put("data_produk", product);
        response.put("status", "Success");

        return response;
    }
}
